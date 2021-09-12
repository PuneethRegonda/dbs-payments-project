export class Session{
    private transferTypes: any
    private messages: any;
    isLoggedIn: boolean;

    constructor(){
        this.transferTypes = [];
        this.isLoggedIn = false;
        this.messages=[];
        this.sessionUser = {
            id:null,
            name:null,
            isEmployee: null,
            token:null
        };
    }

    private  sessionUser : any;

    get getSessionUser(){
        return this.sessionUser;
    }
    setSessionUser(data: any) {
        this.sessionUser = data;    
    }

}