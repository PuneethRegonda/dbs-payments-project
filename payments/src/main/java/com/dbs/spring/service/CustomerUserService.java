package com.dbs.spring.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.beans.CustomerUser;
import com.dbs.spring.repository.CustomerUserRepository;

@Service
public class CustomerUserService {

	public CustomerUserService() {
	}
	
	@Autowired
	private CustomerUserRepository repository;
	

	
	public CustomerUser findCustomerUserById(Integer  userid) {
		try {
			
			System.out.println("USERID: "+userid);
			Optional<CustomerUser> cust = this.repository.findById(userid);
			
			return cust.orElseThrow(()->{	
				return new EntityNotFoundException("Invalid Credentials");
			});
			
			
		}catch(IllegalArgumentException e )
		{
			System.out.println("Error: "+e.getMessage());
			return null;
		}
		
	}
		
}
