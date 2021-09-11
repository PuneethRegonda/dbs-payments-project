import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable()
export class DataService {
    private transferTypes: any
    private messages: any;

    constructor(private http:HttpClient) {
        this.transferTypes = [];
        this.messages=[];
    }


    postDataToApi(url:string,payload:any){
        return this.http.post(url,payload);
    }
   
    getDataFromApi(url:string){
        return this.http.get(url);
    }

    
}