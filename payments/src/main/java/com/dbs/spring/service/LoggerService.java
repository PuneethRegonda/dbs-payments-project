package com.dbs.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.beans.Logger;
import com.dbs.spring.beans.Transaction;
import com.dbs.spring.repository.LoggerRepository;

@Service
public class LoggerService {

	@Autowired
	private LoggerRepository loggerRepository;
	
	public int insertLogger(Logger logger) {
		try {
			return  this.loggerRepository.save(logger).getLoggerid();
		} catch (Exception e) {
			return -1;
		}
	}
	
}
