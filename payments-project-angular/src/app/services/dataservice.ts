import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { AuthService } from "./authService";
import { Session } from "./session";

@Injectable()
export class DataService {


    constructor(private http:HttpClient, private session:Session) {

    }    

    postDataToApi(url:string,payload:any){
        const httpOptions = this.getHeaders();
        return this.http.post(url,payload, httpOptions );
    }
   
    getDataFromApi(url:string){
        const httpOptions = this.getHeaders()
        return this.http.get(url,httpOptions);
    }

    private getHeaders(){
        if(this.session.isLoggedIn){
            return  {
                headers: new HttpHeaders({
                  'Content-Type':  'application/json',
                  Authorization: `Bearer ${this.session.getSessionUser?.token}`
                })
              };
        }else{
            return {
                headers: new HttpHeaders({
                  'Content-Type':  'application/json',
                })
              };
        }
    }
}