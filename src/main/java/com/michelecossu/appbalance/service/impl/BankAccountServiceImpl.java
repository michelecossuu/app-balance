package com.michelecossu.appbalance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.michelecossu.appbalance.dto.BankAccountDto;
import com.michelecossu.appbalance.model.BankAccount;
import com.michelecossu.appbalance.repository.BankAccountRepository;
import com.michelecossu.appbalance.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService{
	
	private final BankAccountRepository bankAccountRepository;

	public BankAccountServiceImpl(BankAccountRepository contoRepository) {
		this.bankAccountRepository = contoRepository;
	}

	@Override
	public List<BankAccountDto> getAllBankAccounts() {
		List<BankAccount> bankAccountList = bankAccountRepository.findAll();
		List<BankAccountDto> bankAccountListDto = new ArrayList<>();
		BankAccountDto bankAccountDto = new BankAccountDto();
		
		if(!bankAccountList.isEmpty()) {
			bankAccountList.forEach(bankAccount -> {
				bankAccountDto.setId(bankAccount.getId());
				bankAccountDto.setName(bankAccount.getName());
				bankAccountDto.setBalance(bankAccount.getBalance());
				bankAccountListDto.add(bankAccountDto);
			});
		}
		
		return bankAccountListDto;
	}

}
