import { Injectable } from "@angular/core";
import { Urls } from "../utils/urls";
import { DataService } from "./dataservice";

@Injectable()
export class TransferService{
    constructor(private dataservices: DataService){}

    private transferData:any;
    private senderAccount:any;

    fetchSenderAccount(customerid:string){
        return this.dataservices.getDataFromApi(
            Urls.customers+customerid);
    }

    fetchRecieverBIC(bic:string){
        return this.dataservices.getDataFromApi(
            Urls.bank+bic);
    }

    get getSenderAccount(){
        return this.senderAccount;
    }

    initTransaction(transactionData: any){
        return this.dataservices.postDataToApi(Urls.initTransfer, transactionData);
    }
}