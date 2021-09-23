export class Transaction{

constructor(
public transactionid : any,
public customerid : any,
public currencycode: any,
public senderBIC:any,
public receiverBIC:any,
public receiveraccountholdernumber:any,
public receiveraccountholdername:any,
public transfertypecode:any,
public messagecode:any,
public currencyamount:any,
public transferfees:any,
public inramount:any,
public transferdate:any
){
    
}

}