package com.dbs.spring.rest;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.beans.MessagesAndTransferType;
import com.dbs.spring.beans.Result;
import com.dbs.spring.service.MessageAndTransferTypesService;

@RestController
@CrossOrigin()
@RequestMapping("/messagecodesandtransfertypes")
public class MessageAndTrasnferTypesRestController {
	
	
	@Autowired
	MessageAndTransferTypesService service;
	
//	url/messagecodesandtransfertypes/
	@GetMapping
	public ResponseEntity<Object> getMessagesAndTransferType() {	
		Result result = new Result();
		try { 
			MessagesAndTransferType messageANDTransferTypes = this.service.getMessagesAndTransferTypes();
			result.setStatus(true);
			result.setMessage("Messages and Transfer Types fetched.");
			result.data = messageANDTransferTypes;
			return ResponseEntity.status(HttpStatus.OK)
					.body(result);			
		}catch (EntityNotFoundException e) {
			System.out.println("error");
			result.setStatus(false);
			result.setMessage(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(result);
		}
	}
	
}
