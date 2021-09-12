package com.dbs.spring.repository;

import org.springframework.data.repository.CrudRepository;


import com.dbs.spring.beans.Employee;

public interface EmployeeUserRepository  extends CrudRepository<Employee, Integer > {

}
