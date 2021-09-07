package com.dbs.spring.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class TransferTypes {
	@Id
	public String code;
	public String description;
}
