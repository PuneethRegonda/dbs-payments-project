package com.dbs.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.dbs.spring.beans.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
}