package com.dbs.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.beans.Bank;

public interface BankRepository extends CrudRepository<Bank, String>{

}
