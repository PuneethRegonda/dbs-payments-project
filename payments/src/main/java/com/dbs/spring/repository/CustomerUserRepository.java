package com.dbs.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.beans.Customer;
import com.dbs.spring.beans.CustomerUser;

public interface CustomerUserRepository extends CrudRepository<CustomerUser, Integer > {

}
