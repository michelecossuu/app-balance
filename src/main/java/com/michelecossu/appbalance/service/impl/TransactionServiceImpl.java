package com.michelecossu.appbalance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.michelecossu.appbalance.dto.BankAccountDto;
import com.michelecossu.appbalance.dto.CategoryDto;
import com.michelecossu.appbalance.dto.TransactionDto;
import com.michelecossu.appbalance.model.BankAccount;
import com.michelecossu.appbalance.model.Category;
import com.michelecossu.appbalance.model.Transaction;
import com.michelecossu.appbalance.repository.TransactionRepository;
import com.michelecossu.appbalance.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	private final TransactionRepository transactionRepository;
	
	public TransactionServiceImpl(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	@Override
	public List<TransactionDto> getAllTransactions() {
		List<Transaction> transactionList = transactionRepository.findAll();
		List<TransactionDto> transactionListDto = new ArrayList<>();
		TransactionDto transactionDto = new TransactionDto();
		
		if(!transactionList.isEmpty()) {
			transactionList.forEach(transaction -> {
				transactionDto.setId(transaction.getId());
				transactionDto.setDescription(transaction.getDescription());
				transactionDto.setDate(transaction.getDate());
				transactionDto.setTransactionType(transaction.getTransactionType());
				//transactionDto.setBankAccount(bankAccountToBankAccountDto(transaction.getBankAccount()));
				//transactionDto.setCategory(categoryToCategoryDto(transaction.getCategory()));				
				transactionListDto.add(transactionDto);
			});
		}
		
		return transactionListDto;
	}
	
	private BankAccountDto bankAccountToBankAccountDto(BankAccount bankAccount) {
		BankAccountDto bankAccountDto = new BankAccountDto();
		
		if(bankAccount != null) {
			bankAccountDto.setId(bankAccount.getId());
			bankAccountDto.setName(bankAccount.getName());
			bankAccountDto.setBalance(bankAccount.getBalance());
		}
		
		return bankAccountDto;
	}
	
	private CategoryDto categoryToCategoryDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		
		if(category != null) {
			categoryDto.setId(category.getId());
			categoryDto.setName(category.getName());
		}
		
		return categoryDto;
	}

}
