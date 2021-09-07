package com.dbs.spring.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Customer {
	@Id
	public String customerid;
	public String accountholdername;
	public Boolean overdraftflag;
	public Double clearbalance;
	public String customeraddress="";
	public String customercity="";
	public String customertype="";
	
	public Customer() {
	}


	public Customer(String customerid, String accountholdername, Boolean overdraftflag, Double clearbalance,
			String customeraddress, String customercity, String customertype) {
		super();
		this.customerid = customerid;
		this.accountholdername = accountholdername;
		this.overdraftflag = overdraftflag;
		this.clearbalance = clearbalance;
		this.customeraddress = customeraddress;
		this.customercity = customercity;
		this.customertype = customertype;
	}



	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getAccountholdername() {
		return accountholdername;
	}

	public void setAccountholdername(String accountholdername) {
		this.accountholdername = accountholdername;
	}

	public Boolean getOverdraftflag() {
		return overdraftflag;
	}

	public void setOverdraftflag(Boolean overdraftflag) {
		this.overdraftflag = overdraftflag;
	}

	public Double getClearbalance() {
		return clearbalance;
	}

	public void setClearbalance(double d) {
		this.clearbalance = d;
	}

	public String getCustomeraddress() {
		return customeraddress;
	}

	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}

	public String getCustomercity() {
		return customercity;
	}

	public void setCustomercity(String customercity) {
		this.customercity = customercity;
	}

	public String getCustomertype() {
		return customertype;
	}

	public void setCustomertype(String customertype) {
		this.customertype = customertype;
	}
	
	

}
