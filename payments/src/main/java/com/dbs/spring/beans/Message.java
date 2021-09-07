package com.dbs.spring.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
public class Message {
	@Id
	public String messagecode;
	public String instruction;
	public String getMessagecode() {
		return messagecode;
	}
	public void setMessagecode(String messagecode) {
		this.messagecode = messagecode;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public Message(String messagecode, String instruction) {
		super();
		this.messagecode = messagecode;
		this.instruction = instruction;
	}
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	
}
