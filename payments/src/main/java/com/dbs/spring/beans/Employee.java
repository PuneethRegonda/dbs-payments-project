package com.dbs.spring.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	public Integer employeeid;
	public String employeename,employeepassword;
	
	public Employee() {
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmployeepassword() {
		return employeepassword;
	}

	public void setEmployeepassword(String employeepassword) {
		this.employeepassword = employeepassword;
	}

	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", employeename=" + employeename + ", employeepassword="
				+ employeepassword + "]";
	}

	
}
