package com.dbs.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.beans.Message;
import com.dbs.spring.beans.MessagesAndTransferType;
import com.dbs.spring.beans.TransferType;
import com.dbs.spring.repository.MessagesRepository;
import com.dbs.spring.repository.TransferTypeRepository;

@Service
public class MessageAndTransferTypesService {
	
	public MessageAndTransferTypesService() {
	}
	
	
	@Autowired
	private MessagesRepository messageRepo;
	
	@Autowired
	private TransferTypeRepository  transferTypesRepo;
	
	public MessagesAndTransferType getMessagesAndTransferTypes()
	{
		List<Message> messages = new ArrayList<Message>();
		this.messageRepo.findAll().forEach(msg->messages.add(msg));
		
		List<TransferType> transferTypes = new ArrayList<TransferType>();
		this.transferTypesRepo.findAll().forEach(transType->transferTypes.add(transType));
		
		return new MessagesAndTransferType(messages,transferTypes);
	}
	
}
