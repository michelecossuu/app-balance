package com.michelecossu.appbalance.service;

import java.util.List;

import com.michelecossu.appbalance.dto.BankAccountDto;

public interface BankAccountService {
	
	List<BankAccountDto> getAllBankAccounts();
	
	BankAccountDto getBankAccountById(long id);
	
	BankAccountDto saveBankAccount(BankAccountDto bankAccountDto);
	
	void deleteBankAccountById(long id);

}
