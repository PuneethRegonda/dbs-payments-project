package com.dbs.spring.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.beans.CustomerUser;
import com.dbs.spring.beans.Employee;
import com.dbs.spring.beans.NetworkCustomer;
import com.dbs.spring.beans.Result;
import com.dbs.spring.service.CustomerUserService;
import com.dbs.spring.utils.JwtUtil;

@RestController
@RequestMapping("/login")
@CrossOrigin()
public class AuthRestController {
	// customeruser - employee login.
	
	@Autowired
	private CustomerUserService customerService;
	
	@Autowired
	private EmployeeUserService employeeService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping
	public ResponseEntity<Object> login(@RequestBody NetworkCustomer candidateUser){
		
		System.out.println("************Login*************");
		Result result = new Result();
		
		try {
			
			CustomerUser user = this.customerService.findCustomerUserById(candidateUser.userid);
			
			if(!user.getUserpassword().equals(candidateUser.getPassword())) {
				result.status = false;
				result.message="Invalid Credentials";
				result.data = null;
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(result);

			}
			final String token = jwtUtil.generateToken(user, false);
						
			result.status = true;
			result.message ="Login Successfull";
			result.data = Map.of(
				    "id", user.getUserid(),
				    "name", user.getUsername(),
				    "isEmployee",false,
				    "token", token
				);
			return ResponseEntity.status(HttpStatus.OK).body(result);

			
		}catch(Exception e) {
			result.status = false;
			result.message=e.getMessage();
			result.data = null;
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(result);

		}
	}
	
	@PostMapping("/employee-login")
	public ResponseEntity<Object> employeeLogin(@RequestBody NetworkCustomer candidateUser){
		Result result = new Result();
		
		try {

			Employee employee = this.employeeService.findCustomerUserById(candidateUser.userid);
			
			if(!employee.getEmployeepassword().equals(candidateUser.getPassword())) {
				result.status = false;
				result.message="Invalid Credentials";
				result.data = null;
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(result);

			}
			final String token = jwtUtil.generateToken(new CustomerUser(employee.getEmployeeid(), employee.getEmployeename(), null, employee.getEmployeepassword()), true);
			
			result.status = true;
			result.message ="Login Successfull";
			result.data = Map.of(
				    "id", employee.getEmployeeid(),
				    "name", employee.getEmployeename(),
				    "isEmployee",true,
				    "token", token
				);
			return ResponseEntity.status(HttpStatus.OK).body(result);

			
		}catch(Exception e) {
			result.status = false;
			result.message=e.getMessage();
			result.data = null;
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(result);

		}
	}
	
	
	
	
}
