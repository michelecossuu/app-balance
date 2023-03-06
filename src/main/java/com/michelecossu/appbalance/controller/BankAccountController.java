package com.michelecossu.appbalance.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michelecossu.appbalance.dto.BankAccountDto;
import com.michelecossu.appbalance.service.BankAccountService;

@RestController
@RequestMapping("/bankAccounts")
@CrossOrigin(origins = "http://localhost:8100")
public class BankAccountController {
	
	private final BankAccountService contoService;
	
	public BankAccountController(BankAccountService contoService) {
		this.contoService = contoService;
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BankAccountDto> getAllBankAccounts() {
		return contoService.getAllBankAccounts();
	}

}
