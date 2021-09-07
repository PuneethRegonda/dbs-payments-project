package com.dbs.spring.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.beans.Bank;
import com.dbs.spring.beans.TransferTypes;
import com.dbs.spring.repository.BankRepository;
import com.dbs.spring.repository.TransferTypeRepository;

@Service
public class BankService {

	@Autowired
	private BankRepository bankRepo;
	
	@Autowired 
	private TransferTypeRepository transferTypeRepo;
	
	public Bank findBankById(String  bic) {
		try {
			Optional<Bank> bank = this.bankRepo.findById(bic);

			return bank.orElseThrow(()->{	
				return new EntityNotFoundException("Bank with "+bic+ " does not exist");
			});

		}catch(IllegalArgumentException e )
		{
			return null;
		}
	}
	public TransferTypes findTransferTypesById(String  id) {
		try {
			Optional<TransferTypes> transferType= this.transferTypeRepo.findById(id);

			return transferType.orElseThrow(()->{	
				return new EntityNotFoundException("No transferType with id "+id+ " exist");
			});

		}catch(IllegalArgumentException e )
		{
			return null;
		}
	}
	
	
	
}
