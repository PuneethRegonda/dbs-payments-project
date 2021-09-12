import { Injectable } from "@angular/core";
import { Urls } from "../utils/urls";
import { DataService } from "./dataservice";


@Injectable()
export class SessionService{
    private static sessionUser : any= {
        id:null,
        name:null,
        isEmployee: null
    };

    isLoggedIn: boolean;

    constructor(private dataservice: DataService){
        this.isLoggedIn = false;
    }

    loginUser(payload:any){
        console.log("payload",payload);
        return this.dataservice.postDataToApi(Urls.userLogin,payload);
    }

    logout(){
        this.isLoggedIn = false;
    }

    employeeLogin(payload:any){
        console.log("payload",payload);
        return this.dataservice.postDataToApi(Urls.employeeLogin,payload);
    }


    static saveSession(data:any){
        SessionService.sessionUser = data;
    }

    get getSessionUser(){
        return SessionService.sessionUser;
    }
}
