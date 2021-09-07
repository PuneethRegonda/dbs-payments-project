package com.dbs.spring.beans;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer transactionid;
	public String  customerid;
	public String currencycode;
	public String senderBIC;
	public String receiverBIC;
	public String receiveraccountholdernumber;
	public String receiveraccountholdername;
	public String transfertypecode, messagecode;
	
	public Double currencyamount,transferfees,inramount;
	
	public LocalDate transferdate;
	
	
	
	public Transaction(Integer transactionid, String customerid, String currencycode, String senderBIC,
			String receiverBIC, String receiveraccountholdernumber, String receiveraccountholdername,
			String transfertypecode, String messagecode, Double currencyamount, Double transferfees, Double inramount,
			LocalDate transferdate) {
		super();
		this.transactionid = transactionid;
		this.customerid = customerid;
		this.currencycode = currencycode;
		this.senderBIC = senderBIC;
		this.receiverBIC = receiverBIC;
		this.receiveraccountholdernumber = receiveraccountholdernumber;
		this.receiveraccountholdername = receiveraccountholdername;
		this.transfertypecode = transfertypecode;
		this.messagecode = messagecode;
		this.currencyamount = currencyamount;
		this.transferfees = transferfees;
		this.inramount = inramount;
		this.transferdate = transferdate;
	}





	public Integer getTransactionid() {
		return transactionid;
	}





	public void setTransactionid(Integer transactionid) {
		this.transactionid = transactionid;
	}





	public String getCustomerid() {
		return customerid;
	}





	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}





	public String getCurrencycode() {
		return currencycode;
	}





	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}





	public String getSenderBIC() {
		return senderBIC;
	}





	public void setSenderBIC(String senderBIC) {
		this.senderBIC = senderBIC;
	}





	public String getReceiverBIC() {
		return receiverBIC;
	}





	public void setReceiverBIC(String receiverBIC) {
		this.receiverBIC = receiverBIC;
	}





	public String getReceiveraccountholdernumber() {
		return receiveraccountholdernumber;
	}





	public void setReceiveraccountholdernumber(String receiveraccountholdernumber) {
		this.receiveraccountholdernumber = receiveraccountholdernumber;
	}





	public String getReceiveraccountholdername() {
		return receiveraccountholdername;
	}





	public void setReceiveraccountholdername(String receiveraccountholdername) {
		this.receiveraccountholdername = receiveraccountholdername;
	}





	public String getTransfertypecode() {
		return transfertypecode;
	}





	public void setTransfertypecode(String transfertypecode) {
		this.transfertypecode = transfertypecode;
	}





	public String getMessagecode() {
		return messagecode;
	}





	public void setMessagecode(String messagecode) {
		this.messagecode = messagecode;
	}





	public Double getCurrencyamount() {
		return currencyamount;
	}





	public void setCurrencyamount(Double currencyamount) {
		this.currencyamount = currencyamount;
	}





	public Double getTransferfees() {
		return transferfees;
	}





	public void setTransferfees(Double transferfees) {
		this.transferfees = transferfees;
	}





	public Double getInramount() {
		return inramount;
	}





	public void setInramount(Double inramount) {
		this.inramount = inramount;
	}





	public LocalDate getTransferdate() {
		return transferdate;
	}





	public void setTransferdate(LocalDate transferdate) {
		this.transferdate = transferdate;
	}





	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	
}
