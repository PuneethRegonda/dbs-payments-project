package com.dbs.spring.filter;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dbs.spring.service.CustomerUserDetailsService;
import com.dbs.spring.service.EmployeeUserDetailsService;
import com.dbs.spring.utils.JwtUtil;



@Component
public class JwtRequestFilter extends OncePerRequestFilter{

	@Autowired
	private CustomerUserDetailsService userservice;
	
	@Autowired
	private EmployeeUserDetailsService employeeservice;
	
	@Autowired
	private JwtUtil jwtutil;
	
	@Override
	// Authorization: Bearer <jwt token>
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String header = request.getHeader("Authorization");
		String username = null;
		String jwt = null;
		System.out.println("************ JWT FILTER ***************");
		System.out.println("Header"+header);
		if(header!=null && header.startsWith("Bearer"))
		{
			System.out.println("jwt exists");
			jwt = header.substring(7);
			System.out.println(jwt);
			username = jwtutil.extractUsername(jwt);
		}
		// /auth => authenticated => jwt back to the client => sends the jwt token and making a request for /cid
		if ( username!=null  && SecurityContextHolder.getContext().getAuthentication()==null)
		{	
			boolean isEmployee ;
			isEmployee = jwtutil.extractisEmployee(jwt);

			System.out.println("isEmployee :"+isEmployee);
			
			System.out.println("username not null in jwt filter "+username);
			UserDetails userDetails ;
			
			if(isEmployee)
				userDetails	= this.employeeservice.loadUserByUsername(username);
			else 
				userDetails = this.userservice.loadUserByUsername(username);

			if(jwtutil.validateToken(jwt, userDetails)) {
				System.out.println("token validated");
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		// servlets, filter and listeners
		filterChain.doFilter(request, response);
	}
	

}
