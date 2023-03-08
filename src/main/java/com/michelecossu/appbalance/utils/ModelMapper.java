package com.michelecossu.appbalance.utils;

import org.mapstruct.Mapper;

import com.michelecossu.appbalance.dto.BankAccountDto;
import com.michelecossu.appbalance.dto.CategoryDto;
import com.michelecossu.appbalance.dto.TransactionDto;
import com.michelecossu.appbalance.model.BankAccount;
import com.michelecossu.appbalance.model.Category;
import com.michelecossu.appbalance.model.Transaction;
import com.michelecossu.appbalance.service.exception.BankAccountNotFoundException;
import com.michelecossu.appbalance.service.exception.CategoryNotFoundException;

@Mapper
public class ModelMapper {
	
	/** BANK ACCOUNT */
	
	public BankAccountDto bankAccountToBankAccountDto(BankAccount bankAccount) {
		BankAccountDto bankAccountDto = new BankAccountDto();

		bankAccountDto.setId(bankAccount.getId());
		bankAccountDto.setName(bankAccount.getName());
		bankAccountDto.setBalance(bankAccount.getBalance());
		
		return bankAccountDto;
	}
	
	public BankAccount bankAccountDtoToBankAccount(BankAccountDto bankAccountDto) {
		BankAccount bankAccount = new BankAccount();
				
		if(bankAccountDto == null) throw new BankAccountNotFoundException("Il BankAccountDto non esiste.");
			
		bankAccount.setName(bankAccountDto.getName());
		bankAccount.setBalance(bankAccountDto.getBalance());
				
		return bankAccount;
	}
	
	/** CATEGORY */
	
	public CategoryDto categoryToCategoryDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();

		categoryDto.setId(category.getId());
		categoryDto.setName(category.getName());
		
		return categoryDto;
	}
	
	public Category categoryDtoToCategory(CategoryDto categoryDto) {
		Category category = new Category();
				
		if(categoryDto == null) throw new CategoryNotFoundException("La CategoryDto non esiste.");
			
		category.setName(categoryDto.getName());
				
		return category;
	}
	
	/** TRANSACTION */
	
	public TransactionDto transactionToTransactionDto(Transaction transaction) {
		TransactionDto transactionDto = new TransactionDto();

		transactionDto.setId(transaction.getId());
		transactionDto.setDescription(transaction.getDescription());
		transactionDto.setDate(transaction.getDate());
		transactionDto.setTransactionType(transaction.getTransactionType());
		transactionDto.setBankAccount(bankAccountToBankAccountDto(transaction.getBankAccount()));
		transactionDto.setCategory(categoryToCategoryDto(transaction.getCategory()));
		
		return transactionDto;
	}
	
	public Transaction transactionDtoToTransaction(TransactionDto transactionDto, BankAccount bankAccount, Category category) {
		Transaction transaction = new Transaction();
				
		if(transactionDto == null) throw new BankAccountNotFoundException("Il BankAccountDto non esiste.");
			
		transaction.setDescription(transactionDto.getDescription());
		transaction.setDate(transactionDto.getDate());
		transaction.setTransactionType(transactionDto.getTransactionType());
		transaction.setBankAccount(bankAccount);
		transaction.setCategory(category);
				
		return transaction;
	}

}
