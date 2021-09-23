package com.dbs.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.beans.Transaction;
import com.dbs.spring.repository.LoggerRepository;
import com.dbs.spring.repository.TransactionRepository;




@Service
public class TransactionService {
	public TransactionService() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private TransactionRepository repository;

	
	public int insertTransaction(Transaction trasaction) {
		if (this.repository.findById(trasaction.transactionid).isPresent())
			return -1;
		try {
			Integer id =  this.repository.save(trasaction).getTransactionid();
			return id;
		} catch (Exception e) {
			return -1;
		}
	}
	
	public List<Transaction> getTransactions(){
		
		return new ArrayList();
	}

//	public List<Transaction> getTransactionsByEmployeeId() {
//		
//		
//	}
	
	
}

