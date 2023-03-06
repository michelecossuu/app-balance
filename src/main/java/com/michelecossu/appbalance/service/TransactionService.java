package com.michelecossu.appbalance.service;

import java.util.List;

import com.michelecossu.appbalance.dto.TransactionDto;

public interface TransactionService {
	
	List<TransactionDto> getAllTransactions();

}
