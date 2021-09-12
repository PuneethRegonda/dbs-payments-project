export class Urls {
    private static baseURL = "http://localhost:8080";  
    static messageCodesandTransferTypes :string = Urls.baseURL+"/messagecodesandtransfertypes";
    static customers: string = Urls.baseURL+"/customers/";
    static bank: string = Urls.baseURL + "/bank/";
    static initTransfer: string = Urls.baseURL+ "/transfer/initTransfer";
    static userLogin: string = Urls.baseURL + "/login";
    static employeeLogin: string = Urls.baseURL + "/login/employee-login";
    
}