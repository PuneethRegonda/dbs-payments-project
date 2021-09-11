export class Urls {
    private static baseURL = "http://localhost:8080";  
    static messageCodesandTransferTypes :string = Urls.baseURL+"/messagecodesandtransfertypes";
    static customers: string = Urls.baseURL+"/customers/";
    static bank: string = Urls.baseURL + "/bank/";
    static initTransfer: string = Urls.baseURL+ "/transfer/initTransfer";
    static login: string = Urls.baseURL + "/login";
}