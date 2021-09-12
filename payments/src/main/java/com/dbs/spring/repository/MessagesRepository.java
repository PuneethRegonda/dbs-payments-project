package com.dbs.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.beans.Message;

public interface MessagesRepository extends CrudRepository<Message, String>{

}
