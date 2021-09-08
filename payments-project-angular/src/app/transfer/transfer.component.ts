import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit {

  totalSteps = 5;
  step: any;
  private isSenderAccVerified:boolean;
  private isRecieverBICVerified:boolean;
  constructor() {
    this.isSenderAccVerified = false;
    this.step = 1;
    this.isRecieverBICVerified = false;
  }

  get recieverBICverified(){
    return this.isRecieverBICVerified;
  }
  get senderAccVerified(){
    return this.isSenderAccVerified;
  }

  transferFormGroup = new FormGroup({
    senderForm : new FormGroup({
      senderAccNumber: new FormControl('',Validators.required),
    }),
   
    recieverForm : new FormGroup({
      recieverBIC: new FormControl('',Validators.required),
      recieverName:new FormControl('',Validators.required),
      recieverAccountNumber:new FormControl('',Validators.required)
    }),

    transferDetailsForm : new FormGroup({
      transferType:new FormControl('',Validators.required),
      message:new FormControl('',Validators.required)    
    }),

    transferAmountForm : new FormGroup({
      amount:new FormControl('',
      [Validators.required,
      Validators.pattern(/^[0-9]+(\.[0-9]+)?$/)
      ]
      ),
    }),


  });


  ngOnInit(): void {
  }

  submit(){


  }

  next(){
    this.step = this.step+1;
  }

  previous(){
    this.step = this.step-1;
  }

  isLastStep(){
    return this.step ==this.totalSteps;
  }


  getFormIsValid(childForm:string){
    return (this.transferFormGroup.get(childForm) as FormArray).valid;
  }

  getChildForm(childForm:string,formcontrol:string){
    return this.transferFormGroup.controls[childForm].get(formcontrol);;
  }

  

  verifySenderAccount(){
    this.isSenderAccVerified = true;
  }

  verifyRecieverBIC(){
    this.isRecieverBICVerified = true;
  }

  onSenderAccChange(event:any){
    // console.log(event);
    this.isSenderAccVerified = false;
  }

  onRecieverBICChange(event:any){
    console.log(event);
    this.isRecieverBICVerified = false;
  }


  isValidNext(){
   let value = false;
    switch(this.step) { 
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
    value = this.getFormIsValid("transferAmountForm"); 
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

  isValidSubmit(){
    return this.transferFormGroup.valid;
  }

}
