package com.dbs.spring.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class CustomerUser {
	@Id
	public Integer userid;
	public String username;
	@OneToOne
	public Customer  customer;
	public String userpassword;
	
	public CustomerUser() {
		// TODO Auto-generated constructor stub
	}

	
	
//
//	public CustomerUser(Integer userid, String username, String customerid, String userpassword) {
//		super();
//		this.userid = userid;
//		this.username = username;
//		this.customerid = customerid;
//		this.userpassword = userpassword;
//	}


	public CustomerUser(Integer userid, String username, Customer customer, String userpassword) {
		super();
		this.userid = userid;
		this.username = username;
		this.customer = customer;
		this.userpassword = userpassword;
	}



	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

	
//	public String getCustomerid() {
//		return customerid;
//	}
//
//
//	public void setCustomerid(String customerid) {
//		this.customerid = customerid;
//	}


	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	
	
}
