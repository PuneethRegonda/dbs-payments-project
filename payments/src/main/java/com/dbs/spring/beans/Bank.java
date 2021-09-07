package com.dbs.spring.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dbs.spring.constants.Constants;

@Entity
public class Bank {
	@Id
	public String bic;
	public String bankname;
	public String getBic() {
		return bic;
	}
	
	public void setBic(String bic) {
		this.bic = bic;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	
	
	@Override
	public String toString() {
		return "Bank [bic=" + bic + ", bankname=" + bankname + "]";
	}
	public Bank(String bic, String bankname) {
		super();
		this.bic = bic;
		this.bankname = bankname;
	}
	public Bank() {
		// TODO Auto-generated constructor stub
	}

	public boolean isInternalBank() {
		
		return this.bankname.contains(Constants.OWN_BANK);
	}
}
