import { Injectable } from "@angular/core";
import { Urls } from "../utils/urls";
import { DataService } from "./dataservice";
import { Session } from "./session";


@Injectable()
export class AuthService{


    constructor(private dataservice: DataService,private session: Session){
    }

    loginUser(payload:any){
        console.log("payload",payload);
        return this.dataservice.postDataToApi(Urls.userLogin,payload);
    }

    logout(){
        this.session.isLoggedIn = false;

    }

    employeeLogin(payload:any){
        console.log("payload",payload);
        return this.dataservice.postDataToApi(Urls.employeeLogin,payload);
    }


     saveSession(data:any){
      this.session.setSessionUser(data);
    }

}
