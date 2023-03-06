package com.michelecossu.appbalance.service;

import java.util.List;

import com.michelecossu.appbalance.dto.BankAccountDto;

public interface BankAccountService {
	
	List<BankAccountDto> getAllBankAccounts();

}
