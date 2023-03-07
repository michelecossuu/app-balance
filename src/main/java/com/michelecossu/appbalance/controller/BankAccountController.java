package com.michelecossu.appbalance.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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

import com.michelecossu.appbalance.dto.BankAccountDto;
import com.michelecossu.appbalance.service.BankAccountService;

@RestController
@RequestMapping("/bankAccounts")
@CrossOrigin(origins = "http://localhost:8100")
public class BankAccountController {
	
	private final BankAccountService bankAccountService;
	
	public BankAccountController(BankAccountService contoService) {
		this.bankAccountService = contoService;
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BankAccountDto>> getAllBankAccounts() {
		return ResponseEntity.ok(bankAccountService.getAllBankAccounts());
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BankAccountDto> getBankAccountById(@PathVariable long id) {
		return ResponseEntity.ok(bankAccountService.getBankAccountById(id));
	}
	
	@DeleteMapping("/deleteBankAccount/{id}")
	public ResponseEntity<String> deleteBankAccountById(@PathVariable long id) {
		bankAccountService.deleteBankAccountById(id);
		String response = "Il bank account con l'id " + id + " è stato cancellato correttamente.";
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/newBankAccount", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BankAccountDto> saveBankAccount(@RequestBody BankAccountDto bankAccountDto) {
		return ResponseEntity.ok(bankAccountService.saveBankAccount(bankAccountDto));
	}

}
