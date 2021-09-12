package com.dbs.spring.rest;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.beans.Customer;
import com.dbs.spring.beans.Result;
import com.dbs.spring.service.CustomerService;
	
@RestController
@CrossOrigin()
@RequestMapping("/customers")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;

	public CustomerRestController() {
		// TODO Auto-generated constructor stub
	}
	
//	url/customer/{customerid}
	@GetMapping("/{customerid}")
	public ResponseEntity<Object> findCustomerById(@PathVariable String customerid) {
		System.out.println("Customer "+customerid);
		Result result = new Result();
		try { 
			Customer customer = this.customerService.findCustomerById(customerid);
			result.setStatus(true);
			result.setMessage("Customer found");
			result.data = customer;
			return ResponseEntity.status(HttpStatus.OK)
					.body(result);			
		}catch (EntityNotFoundException e) {
			System.out.println("error: "+e.getMessage());
			result.setStatus(false);
			result.setMessage(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(result);
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> getCustomers(){
		Result result = new Result();
		result.setData(this.customerService.getCustomers());
		if(result.data!=null)
			result.setStatus(true);
		return ResponseEntity.status(HttpStatus.OK)
				.body(result);
	}
	
}
