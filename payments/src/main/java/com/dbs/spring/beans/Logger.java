package com.dbs.spring.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Logger {
	@Id
	private Integer loggerid;
	private String customerid;
	private Integer userid, employeeid;
	private String screename,action,ipaddress;
	
	public Logger() {
	}
	
	
	public Logger(Integer loggerid, String customerid, Integer userid, Integer employeeid, String screename,
			String action, String ipaddress) {
		super();
		this.loggerid = loggerid;
		this.customerid = customerid;
		this.userid = userid;
		this.employeeid = employeeid;
		this.screename = screename;
		this.action = action;
		this.ipaddress = ipaddress;
	}



	public Integer getLoggerid() {
		return loggerid;
	}

	public void setLoggerid(Integer loggerid) {
		this.loggerid = loggerid;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getScreename() {
		return screename;
	}

	public void setScreename(String screename) {
		this.screename = screename;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	@Override
	public String toString() {
		return "Logger [loggerid=" + loggerid + ", customerid=" + customerid + ", userid=" + userid + ", employeeid="
				+ employeeid + ", screename=" + screename + ", action=" + action + ", ipaddress=" + ipaddress + "]";
	}
	
	
}
