package com.michelecossu.appbalance.service;

import java.util.List;

import com.michelecossu.appbalance.dto.TransactionDto;

public interface TransactionService {
	
	List<TransactionDto> getAllTransactions();
	
	List<TransactionDto> getAllTransactionByBankAccount(long id);
	
	List<TransactionDto> getAllTransactionByBankAccountAndCategory(long bankAccountId, long categoryId);
	
	TransactionDto getTransactionById(long id);
	
	TransactionDto saveTransaction(TransactionDto transactionDto);
	
	void deleteTransactionById(long id);

}
