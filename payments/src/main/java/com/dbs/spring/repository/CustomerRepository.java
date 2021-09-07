package com.dbs.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.beans.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String > {

}
