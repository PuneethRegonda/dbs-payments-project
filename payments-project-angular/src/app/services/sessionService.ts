import { Injectable } from "@angular/core";


@Injectable()
export class SessionService{
    isLoggedIn: boolean;

    constructor(){
        this.isLoggedIn = false;
    }

    loginUser(username:string, password:string){
        console.log("username:",username,"password:",password);
        this.isLoggedIn = true;
    }

    logout(){
        this.isLoggedIn = false;
    }


}