export class Session{
    private transferTypes: any
    private messages: any;
    public isLoggedIn: boolean = false;

    constructor(){
        this.transferTypes = [];
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
    isauthenticated(){
        return this.isLoggedIn;
    }
    setSessionUser(data: any) {
        this.sessionUser = data;    
    }

}