package com.michelecossu.appbalance.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<TransactionDto> getAllTransactions() {
		return transactionService.getAllTransactions();
	}

}
