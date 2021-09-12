import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { MessagesServices } from '../services/messagecodes.service';
import { AuthService } from '../services/authService';
import { TransferService } from '../services/transfer.service';
import { Session } from '../services/session';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit {

  private _senderAccount: any;

  private _transferTypes: any;

  get gettransferTypes() {
    return this._transferTypes;
  }

  private _messageCodes: any;

  get getMessageCodes() {
    return this._messageCodes;
  }

  get getSenderAccount() {
    return this._senderAccount;
  }
  private _recieverBIC: any;

  get getrecieverBIC() {
    return this._recieverBIC;
  }
  totalSteps = 5;
  step: any;

  private isSenderAccVerified: boolean;
  private isRecieverBICVerified: boolean;
  constructor(
    private transferservice: TransferService,
    private messageService: MessagesServices,
    private sessionService : AuthService,
    private session : Session
    ) {
    this.isSenderAccVerified = false;
    this.step = 1;
    this.isRecieverBICVerified = false;
  }

  get recieverBICverified() {
    return this.isRecieverBICVerified;
  }
  get senderAccVerified() {
    return this.isSenderAccVerified;
  }

  transferFormGroup = new FormGroup({
    senderForm: new FormGroup({
      senderAccNumber: new FormControl('', Validators.required),
    }),

    recieverForm: new FormGroup({
      recieverBIC: new FormControl('', Validators.required),
      recieverName: new FormControl('', Validators.required),
      recieverAccountNumber: new FormControl('', Validators.required)
    }),

    transferDetailsForm: new FormGroup({
      transferType: new FormControl('', Validators.required),
      message: new FormControl('', Validators.required)
    }),

    transferAmountForm: new FormGroup({
      amount: new FormControl('',
        [Validators.required,
        Validators.pattern(/^[0-9]+(\.[0-9]+)?$/)
        ]
      ),
    }),


  });


  ngOnInit(): void {
    this.fetchTransferTypesandMessages();
  }

  submit() {
      /**
       * 	public String sendCustomerId,senderBIC,recieverBIC,recieverAccountNumber,recieverAccHolderName,transferTypeId,messageCodeId,currencyCode;
        	public Double transferAmount, transactionFee;
	        public Boolean isEmployeeTransfer;
	        public String employeeId;

          #CUSTOMER
          accountholdername: "ABHITHA"
          clearbalance: 223997
          customeraddress: ""
          customercity: ""
          customerid: "87139550565094"
          customertype: ""
          overdraftflag: false
          
          #BANK
          bankname: "DBS BANK LTD, MUMBAI BRANCH"
          bic: "DBSSINBBIBD"
          internalBank: false

       */
    
     let transactionData :any ={
      sendCustomerId: this.getSenderAccount?.customerid,
      senderBIC: "",
      recieverBIC:this.getrecieverBIC.bic, recieverAccountNumber:this.getChildForm('recieverForm','recieverAccountNumber')?.value,
      recieverAccHolderName:this.getChildForm('recieverForm','recieverName')?.value,
      transferTypeId : this.getChildForm('transferDetailsForm','transferType')?.value,
      messageCodeId : this.getChildForm('transferDetailsForm','message')?.value,
      currencyCode:"INR",
      transferAmount:this.getChildForm('transferAmountForm','amount')?.value,
      transactionFee:this.getChildForm('transferAmountForm','amount')?.value*0.25,
      isEmployeeTransfer:this.session.getSessionUser?.isEmployee,
      employeeId: this.session.getSessionUser?.isEmployee ? this.session.getSessionUser.id:null,
      userid: this.session.getSessionUser?.isEmployee ? null:this.session.getSessionUser.id
     }
     console.log(transactionData);
     this.transferservice.initTransaction(transactionData).subscribe((result:any)=>{
        console.log(result);
     });
  }

  next() {
    this.step = this.step + 1;
  }

  previous() {
    this.step = this.step - 1;
  }

  isLastStep() {
    return this.step == this.totalSteps;
  }


  getFormIsValid(childForm: string) {
    return (this.transferFormGroup.get(childForm) as FormArray).valid;
  }

  getChildForm(childForm: string, formcontrol: string) {
    return this.transferFormGroup.controls[childForm].get(formcontrol);;
  }




  verifyRecieverBIC() {
    this.isRecieverBICVerified = true;
  }

  onSenderAccChange(event: any) {
    // console.log(event);
    this.isSenderAccVerified = false;
  }

  onRecieverBICChange(event: any) {
    console.log(event);
    this.isRecieverBICVerified = false;
  }


  isValidNext() {
    let value = false;
    switch (this.step) {
      case 1: {
        value = this.getFormIsValid("senderForm") && this.isSenderAccVerified;
        break;
      }
      case 2: {
        value = this.getFormIsValid("recieverForm") && this.recieverBICverified;
        break;
      }
      case 3: {
        value = this.getFormIsValid("transferDetailsForm");
        break;
      }
      case 4: {
        value = this.getFormIsValid("transferAmountForm") && !this.isMoneyOverflow;
        break;
      }
      case 5: {
        value = false;
        break;
      }
      default: {
        value = false;
        break;
      }
    }
    return value;
  }

  isValidSubmit() {
    return this.transferFormGroup.valid;
  }


  // fetching data:

  verifyLoadSenderAcc() {
    let senderAccFormControl: AbstractControl | null = this.getChildForm('senderForm', 'senderAccNumber');

    if (senderAccFormControl?.valid) {
      this.transferservice.fetchSenderAccount(senderAccFormControl.value).subscribe((response: any) => {
        if (response && response?.status) {
          this.isSenderAccVerified = true;
          console.log("response:", response);
          this._senderAccount = response?.data;
        }
      }, err => {
        console.log("ERROR: " + err);
      });
    }

  }

  verifyLoadRecipientBIC() {
    let recieveraccFormControl: AbstractControl | null = this.getChildForm('recieverForm', 'recieverBIC');

    if (recieveraccFormControl?.valid) {
      this.transferservice.fetchRecieverBIC(recieveraccFormControl.value).subscribe((response: any) => {
        if (response && response?.status) {
          this.isRecieverBICVerified = true;
          console.log("response:", response);
          this._recieverBIC = response?.data;
        }
      }, err => {
        console.log("ERROR: " + err);
      });

    }

  }

  fetchTransferTypesandMessages(){
    this.messageService.fetechMessagesAndTransferTypes().subscribe((response: any) => {
      if (response && response?.status) {
        console.log("response:", response);
        this._transferTypes = response?.data?.transferTypes;
        this._messageCodes = response?.data?.messages
      }
    }, err => {
      console.log("ERROR: " + err);
    });
  }

  get isMoneyOverflow(){
    return !this.getSenderAccount?.overdraftflag && this.getSenderAccount?.clearbalance<this.getChildForm('transferAmountForm','amount')?.value
  }

  get gettransferText(){
    let text :string= "";
    this.gettransferTypes.forEach( (element:any)=> {
      if(element?.code == this.getChildForm('transferDetailsForm','transferType')?.value) 
        text =  element.description;
    });
    return text;
  }

  
  get getmessageText(){
    let text :string= "";
    this.getMessageCodes.forEach( (element:any)=> {
      if(element?.messagecode == this.getChildForm('transferDetailsForm','message')?.value) 
        text =  element.instruction;
    });
    return text;  
  }

}
