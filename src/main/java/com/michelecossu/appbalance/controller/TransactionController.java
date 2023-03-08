package com.michelecossu.appbalance.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michelecossu.appbalance.dto.TransactionDto;
import com.michelecossu.appbalance.service.TransactionService;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "http://localhost:8100")
public class TransactionController {
	
	private final TransactionService transactionService;

	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionDto>> getAllTransactions() {
		return ResponseEntity.ok(transactionService.getAllTransactions());
	}
	
	@GetMapping(value = "/all/bankAccounts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionDto>> getAllTransactionByBankAccount(@PathVariable long id) {
		return ResponseEntity.ok(transactionService.getAllTransactionByBankAccount(id));
	}
		
	@GetMapping(value="all/bankAccounts/{bankAccountId}/categories/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionDto>> getAllTransactionByBankAccountAndCategory(@PathVariable long bankAccountId, @PathVariable long categoryId) {
		return ResponseEntity.ok(transactionService.getAllTransactionByBankAccountAndCategory(bankAccountId, categoryId));
	}
	
	@PostMapping(value = "/newTransaction", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionDto> saveTransaction(@RequestBody TransactionDto transactionDto) {
		return ResponseEntity.ok(transactionService.saveTransaction(transactionDto));
	}
				
	@DeleteMapping("/deleteTransaction/{id}")
	public ResponseEntity<String> deleteTransactionById(@PathVariable long id) {
		transactionService.deleteTransactionById(id);
		String response = "La transazione con l'id " + id + " è stata cancellata correttamente.";
		return ResponseEntity.ok(response);
	}
}
