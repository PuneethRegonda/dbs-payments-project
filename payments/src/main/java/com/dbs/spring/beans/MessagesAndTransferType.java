package com.dbs.spring.beans;

import java.util.List;

public class MessagesAndTransferType {
	private List<Message> messages;
	private List<TransferType> transferTypes;
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<TransferType> getTransferTypes() {
		return transferTypes;
	}
	public void setTransferTypes(List<TransferType> transferTypes) {
		this.transferTypes = transferTypes;
	}
	
	public MessagesAndTransferType() {
	}
	public MessagesAndTransferType(List<Message> messages, List<TransferType> transferTypes) {
		super();
		this.messages = messages;
		this.transferTypes = transferTypes;
	}
	@Override
	public String toString() {
		return "MessagesAndTransferType [messages=" + messages + ", transferTypes=" + transferTypes + "]";
	}
	
}
