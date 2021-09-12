package com.dbs.spring.beans;

public class NetworkCustomer {
	

	public Integer userid;
	public String password;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public NetworkCustomer() {
	}
	
	@Override
	public String toString() {
		return "NetworkCustomer [userid=" + userid + ", password=" + password + "]";
	}
}
