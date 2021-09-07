package com.dbs.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.beans.Bank;
import com.dbs.spring.beans.Logger;

public interface LoggerRepository extends CrudRepository<Logger, String>{

}
