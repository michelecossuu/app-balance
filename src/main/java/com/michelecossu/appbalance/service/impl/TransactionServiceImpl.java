package com.michelecossu.appbalance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.michelecossu.appbalance.dto.TransactionDto;
import com.michelecossu.appbalance.model.BankAccount;
import com.michelecossu.appbalance.model.Category;
import com.michelecossu.appbalance.model.Transaction;
import com.michelecossu.appbalance.repository.BankAccountRepository;
import com.michelecossu.appbalance.repository.CategoryRepository;
import com.michelecossu.appbalance.repository.TransactionRepository;
import com.michelecossu.appbalance.service.TransactionService;
import com.michelecossu.appbalance.service.exception.TransactionNotFoundException;
import com.michelecossu.appbalance.utils.ModelMapper;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	private final TransactionRepository transactionRepository;
	private final BankAccountRepository  bankAccountRepository;
	private final CategoryRepository categoryRepository;
	private ModelMapper mapper;
	
	public TransactionServiceImpl(TransactionRepository transactionRepository, 
			BankAccountRepository bankAccountRepository,
			CategoryRepository categoryRepository,
			ModelMapper mapper) {
		this.transactionRepository = transactionRepository;
		this.bankAccountRepository = bankAccountRepository;
		this.categoryRepository = categoryRepository;
		this.mapper = mapper;
	}

	@Override
	public List<TransactionDto> getAllTransactions() {
		List<Transaction> transactionList = transactionRepository.findAll();
		return makeTransactionListDto(transactionList);
	}
	
	@Override
	public List<TransactionDto> getAllTransactionByBankAccount(long id) {
		List<Transaction> transactionList = transactionRepository.findAllByBankAccountId(id);
		return makeTransactionListDto(transactionList);
	}
	
	@Override
	public List<TransactionDto> getAllTransactionByBankAccountAndCategory(long bankAccountId, long categoryId) {
		List<Transaction> transactionList = transactionRepository.findAllByBankAccountIdAndCategoryId(bankAccountId, categoryId);
		return makeTransactionListDto(transactionList);
	}

	@Override
	public TransactionDto getTransactionById(long id) {
		Transaction transaction = transactionRepository.findById(id);
		
		if(transaction == null) throw new TransactionNotFoundException("La Transaction con l'id " + id + " non esiste.");
		
		return mapper.transactionToTransactionDto(transaction);
	}

	@Override
	public TransactionDto saveTransaction(TransactionDto transactionDto) {
		
		if(transactionDto == null) throw new TransactionNotFoundException("La Transaction è nulla.");
		if(transactionDto.getBankAccount() == null) throw new TransactionNotFoundException("Il BankAccount è nullo.");
		if(transactionDto.getCategory() == null) throw new TransactionNotFoundException("La Category non è nulla.");
		
		BankAccount bankAccount = bankAccountRepository.findById(transactionDto.getBankAccount().getId());
		Category category = categoryRepository.findById(transactionDto.getCategory().getId());
		
		Transaction transaction = transactionRepository.save(mapper.transactionDtoToTransaction(transactionDto, bankAccount, category));
		transactionDto.setId(transaction.getId());
								
		return transactionDto;
	}

	@Override
	public void deleteTransactionById(long id) {
		Transaction transaction = transactionRepository.findById(id);

		if(transaction == null) throw new TransactionNotFoundException("La Transaction con l'id " + id + " non esiste.");

		transactionRepository.deleteById(id);	
	}
	
	private List<TransactionDto> makeTransactionListDto(List<Transaction> transactionList) {
		List<TransactionDto> transactionListDto = new ArrayList<>();
		
		if(!transactionList.isEmpty()) {
			transactionList.forEach(transaction -> {
				TransactionDto transactionDto = new TransactionDto();
				transactionDto.setId(transaction.getId());
				transactionDto.setDescription(transaction.getDescription());
				transactionDto.setDate(transaction.getDate());
				transactionDto.setTransactionType(transaction.getTransactionType());
				transactionDto.setBankAccount(mapper.bankAccountToBankAccountDto(transaction.getBankAccount()));
				transactionDto.setCategory(mapper.categoryToCategoryDto(transaction.getCategory()));				
				transactionListDto.add(transactionDto);
			});
		}
		
		return transactionListDto;
	}

}
