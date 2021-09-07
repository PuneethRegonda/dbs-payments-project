package com.dbs.spring.beans;

public class Result {
	
	public boolean status = false;
	public String message;
	public Object data;
	
	

	public Result(boolean status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public Object getData() {
		return data;
	}



	public void setData(Object data) {
		this.data = data;
	}



	public Result() {
		this.data = null;
		this.status = false;
		this.message= null;
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Result [status=" + status + ", message=" + message + ", data=" + data + "]";
	}

	
}
