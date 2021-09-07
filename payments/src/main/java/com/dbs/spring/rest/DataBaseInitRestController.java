package com.dbs.spring.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.beans.Bank;
import com.dbs.spring.beans.Customer;
import com.dbs.spring.repository.BankRepository;
import com.dbs.spring.repository.CustomerRepository;
import com.dbs.spring.utils.PaymentsDatabaseInitializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/init")
public class DataBaseInitRestController {

	@Autowired
	private BankRepository bankRepo;
	@Autowired
	private CustomerRepository customerRepo;
	
	
	@GetMapping
	public void initialize() throws JsonMappingException, JsonProcessingException {
		System.out.println("database init running");
		if(PaymentsDatabaseInitializer.BUILD_DB) {
			
			ObjectMapper mapper = new ObjectMapper();
			/**
			 * 
			 *  bank table
			 */
			List<Bank> banks = Arrays.asList(mapper.readValue(PaymentsDatabaseInitializer.BANKSJSON, Bank[].class));
			bankRepo.saveAll(banks);
			for (Bank bank : banks) {
				System.out.println(bank);
			}
			/**
			 *  customer table
			 */
			
			List<Customer> customers = Arrays.asList(mapper.readValue(PaymentsDatabaseInitializer.CUSTOMERJSON, Customer[].class));
			customerRepo.saveAll(customers);
			for (Customer cust : customers) {
				System.out.println(cust);
			}
			
			
		}
	}
	
}
