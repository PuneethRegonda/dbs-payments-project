package com.dbs.spring.rest;


import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.beans.CustomerUser;
import com.dbs.spring.beans.Employee;
import com.dbs.spring.repository.CustomerUserRepository;
import com.dbs.spring.repository.EmployeeUserRepository;

@Service
public class EmployeeUserService {

	public EmployeeUserService() {
	}
	
	@Autowired
	private EmployeeUserRepository repository;
	

	
	public Employee findCustomerUserById(Integer  userid) {
		try {
			
			System.out.println("USERID: "+userid);
			Optional<Employee> cust = this.repository.findById(userid);
			
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
