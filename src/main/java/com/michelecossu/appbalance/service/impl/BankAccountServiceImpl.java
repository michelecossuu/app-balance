package com.michelecossu.appbalance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.michelecossu.appbalance.dto.BankAccountDto;
import com.michelecossu.appbalance.model.BankAccount;
import com.michelecossu.appbalance.repository.BankAccountRepository;
import com.michelecossu.appbalance.service.BankAccountService;
import com.michelecossu.appbalance.service.exception.BankAccountNotFound;

@Service
public class BankAccountServiceImpl implements BankAccountService{
	
	private final BankAccountRepository bankAccountRepository;
	
    private static final Logger logger = LogManager.getLogger(BankAccountServiceImpl.class);
		
	public BankAccountServiceImpl(BankAccountRepository contoRepository) {
		this.bankAccountRepository = contoRepository;
	}

	@Override
	public List<BankAccountDto> getAllBankAccounts() {
		List<BankAccount> bankAccountList = bankAccountRepository.findAll();
		List<BankAccountDto> bankAccountListDto = new ArrayList<>();
		
		if(!bankAccountList.isEmpty()) {
			bankAccountList.forEach(bankAccount -> {
				BankAccountDto bankAccountDto = new BankAccountDto();
				bankAccountDto.setId(bankAccount.getId());
				bankAccountDto.setName(bankAccount.getName());
				bankAccountDto.setBalance(bankAccount.getBalance());
				bankAccountListDto.add(bankAccountDto);
			});
		}
		
		return bankAccountListDto;
	}

	@Override
	public BankAccountDto getBankAccountById(long id) {
		BankAccount bankAccount = bankAccountRepository.findById(id);
		
		if(bankAccount == null) throw new BankAccountNotFound("Il BankAccount con l'id " + id + " non esiste.");
		
		BankAccountDto bankAccountDto = bankAccountToBankAccountDto(bankAccount);
		
		return bankAccountDto;
	}

	@Override
	public BankAccountDto saveBankAccountById(BankAccountDto bankAccountDto) {
		
		logger.info("saveBankAccount - inizio metodo");
		
		if(bankAccountDto == null) throw new BankAccountNotFound("Il BankAccountDto non è corretto.");
		
		BankAccount bankAccount = bankAccountRepository.save(bankAccountDtoToBankAccount(bankAccountDto));
		bankAccountDto.setId(bankAccount.getId());
				
		logger.info("saveBankAccount - fine metodo");
				
		return bankAccountDto;
	}
	
	@Override
	public void deleteBankAccountById(long id) {
		BankAccount bankAccount = bankAccountRepository.findById(id);
		
		if(bankAccount == null) throw new BankAccountNotFound("Il BankAccount con l'id " + id + " non esiste.");
		
		bankAccountRepository.deleteById(id);
	}
	
	private BankAccountDto bankAccountToBankAccountDto(BankAccount bankAccount) {
		BankAccountDto bankAccountDto = new BankAccountDto();

		bankAccountDto.setId(bankAccount.getId());
		bankAccountDto.setName(bankAccount.getName());
		bankAccountDto.setBalance(bankAccount.getBalance());
		
		return bankAccountDto;
	}
	
	private BankAccount bankAccountDtoToBankAccount(BankAccountDto bankAccountDto) {
		BankAccount bankAccount = new BankAccount();
		
		logger.info("bankAccountDtoToBankAccount - inizio metodo");
		
		if(bankAccountDto == null) throw new BankAccountNotFound("Il BankAccountDto non esiste.");
			
		bankAccount.setName(bankAccountDto.getName());
		bankAccount.setBalance(bankAccountDto.getBalance());
		
		logger.info("bankAccountDtoToBankAccount - fine metodo");
		
		return bankAccount;
	}

}
