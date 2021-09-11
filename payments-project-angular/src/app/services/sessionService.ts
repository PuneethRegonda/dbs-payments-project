import { Injectable } from "@angular/core";
import { Urls } from "../utils/urls";
import { DataService } from "./dataservice";


@Injectable()
export class SessionService{
    isLoggedIn: boolean;

    constructor(private dataservice: DataService){
        this.isLoggedIn = false;
    }

    loginUser(payload:any){
        console.log("payload",payload);

        return this.dataservice.postDataToApi(Urls.login,payload);
    }

    logout(){
        this.isLoggedIn = false;
    }


    

}