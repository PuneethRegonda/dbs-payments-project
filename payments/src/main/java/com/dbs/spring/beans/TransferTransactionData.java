package com.dbs.spring.beans;

public class TransferTransactionData {
	
	public String sendCustomerId,senderBIC,recieverBIC,recieverAccountNumber,recieverAccHolderName,transferTypeId,messageCodeId,currencyCode;
	public Double transferAmount, transactionFee;
	public Boolean isEmployeeTransfer;
	public Integer employeeId;
	public Integer userid;
	

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public TransferTransactionData() {
	}

	public String getSendCustomerId() {
		return sendCustomerId;
	}

	public void setSendCustomerId(String sendCustomerId) {
		this.sendCustomerId = sendCustomerId;
	}

	public String getSenderBIC() {
		return senderBIC;
	}

	public void setSenderBIC(String senderBIC) {
		this.senderBIC = senderBIC;
	}

	public String getRecieverBIC() {
		return recieverBIC;
	}

	public void setRecieverBIC(String recieverBIC) {
		this.recieverBIC = recieverBIC;
	}

	public String getRecieverAccountNumber() {
		return recieverAccountNumber;
	}

	public void setRecieverAccountNumber(String recieverAccountNumber) {
		this.recieverAccountNumber = recieverAccountNumber;
	}

	public String getRecieverAccHolderName() {
		return recieverAccHolderName;
	}

	public void setRecieverAccHolderName(String recieverAccHolderName) {
		this.recieverAccHolderName = recieverAccHolderName;
	}

	public String getTransferTypeId() {
		return transferTypeId;
	}

	public void setTransferTypeId(String transferTypeId) {
		this.transferTypeId = transferTypeId;
	}

	public String getMessageCodeId() {
		return messageCodeId;
	}

	public void setMessageCodeId(String messageCodeId) {
		this.messageCodeId = messageCodeId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(Double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public Double getTransactionFee() {
		return transactionFee;
	}

	public void setTransactionFee(Double transactionFee) {
		this.transactionFee = transactionFee;
	}

	public Boolean getIsEmployeeTransfer() {
		return isEmployeeTransfer;
	}

	public void setIsEmployeeTransfer(Boolean isEmployeeTransfer) {
		this.isEmployeeTransfer = isEmployeeTransfer;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "TransferTransactionData [sendCustomerId=" + sendCustomerId + ", senderBIC=" + senderBIC
				+ ", recieverBIC=" + recieverBIC + ", recieverAccountNumber=" + recieverAccountNumber
				+ ", recieverAccHolderName=" + recieverAccHolderName + ", transferTypeId=" + transferTypeId
				+ ", messageCodeId=" + messageCodeId + ", currencyCode=" + currencyCode + ", transferAmount="
				+ transferAmount + ", transactionFee=" + transactionFee + ", isEmployeeTransfer=" + isEmployeeTransfer
				+ ", employeeId=" + employeeId + "]";
	}
	
	
	
}

