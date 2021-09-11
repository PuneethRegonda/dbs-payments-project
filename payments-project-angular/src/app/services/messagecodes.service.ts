import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Urls } from "../utils/urls";
import { DataService } from "./dataservice";

@Injectable()
export class MessagesServices {
    private transferTypes: any
    private messages: any;

    constructor(private http: HttpClient, private dataservice: DataService) {
        this.transferTypes = [];
        this.messages = [];
    }

    fetechMessagesAndTransferTypes() {
       return  this.dataservice.getDataFromApi(Urls.messageCodesandTransferTypes)
       
    }

    get getMessages() {
        return this.messages;
    }

    private setmessagesData(messages: any) {
        this.messages = messages;
    }




}