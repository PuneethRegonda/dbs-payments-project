package com.dbs.spring.rest;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.beans.Bank;
import com.dbs.spring.beans.Customer;
import com.dbs.spring.beans.Result;
import com.dbs.spring.service.BankService;

@RestController
@CrossOrigin()
@RequestMapping("/bank")
public class BankRestController {

	public BankRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private BankService bankService;
	
//	url/bank/{bic}
	@GetMapping("/{bic}")
	public ResponseEntity<Object> findBankById(@PathVariable String bic) {
		Result result = new Result();
		try { 
			Bank bank = this.bankService.findBankById(bic);
			result.setStatus(true);
			result.setMessage("Bank found");
			result.data = bank;
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
