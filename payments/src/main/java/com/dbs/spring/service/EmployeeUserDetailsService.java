package com.dbs.spring.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dbs.spring.beans.CustomerUser;
import com.dbs.spring.beans.Employee;
import com.dbs.spring.repository.CustomerUserRepository;
import com.dbs.spring.repository.EmployeeUserRepository;

@Service
public class EmployeeUserDetailsService implements UserDetailsService{

	@Autowired
	private EmployeeUserRepository employeeRepo;
	

	
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		
		System.out.println("User Id "+userid);
		Optional<Employee> optional = this.employeeRepo.findById(Integer.valueOf(userid));
//		return optional.map(account ->{
//			User user = new User(account.getUsername(), account.getPassword(),
//					Arrays.stream(account.getRole().split(","))
//					.map(role -> new SimpleGrantedAuthority(role))
//					.collect(Collectors.toList()));
//			return user;
//			
//		}).orElseThrow(()-> new UsernameNotFoundException("Invalid Credentials"));
		
//		use below code if you are not providing roles	
		
		return optional.map(account ->{
			User user = new User(account.getEmployeeid().toString(), account.getEmployeepassword(),
					new ArrayList<>());
			return user;
			
		}).orElseThrow(()-> new UsernameNotFoundException("Invalid Credentials"));
	}
}
