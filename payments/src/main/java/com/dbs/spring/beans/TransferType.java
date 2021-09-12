package com.dbs.spring.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity(name="transfertypes")
public class TransferType extends Object{
	@Id
	public String code;
	public String description;
}
