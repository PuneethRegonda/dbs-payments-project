package com.dbs.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.beans.Customer;
import com.dbs.spring.repository.CustomerRepository;

@Service
public class CustomerService {

	public CustomerService() {
	}
	
	@Autowired
	private CustomerRepository repository;
	
//	public boolean insertCustomer(Customer customer) {
//	if(this.repository.findById(customer.customerid).isPresent())
//		return false;
//	try {
//		this.repository.save(customer);
//		return true;
//	}catch(Exception e) {
//		return false;
//	}
//}
//
	
	public boolean updateCustomer(Customer customer) {
	try {
		if(this.repository.findById(customer.customerid).isPresent())
			return this.repository.save(customer)!=null;
		return false;
	}catch(Exception e) {
		return false;
	}
}

	
	public Customer findCustomerById(String  customerid) {
		try {
			Optional<Customer> cust = this.repository.findById(customerid);

			return cust.orElseThrow(()->{	
				return new EntityNotFoundException("Customer with "+customerid+ " does not exist");
			});

		}catch(IllegalArgumentException e )
		{
			return null;
		}
	}
	
	public List<Customer> getCustomers()
	{
		List<Customer> customers = new ArrayList<Customer>();
		this.repository.findAll().forEach(cust->customers.add(cust));
		return customers;
	}	
}
