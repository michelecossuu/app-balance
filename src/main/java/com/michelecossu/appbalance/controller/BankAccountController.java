package com.michelecossu.appbalance.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.michelecossu.appbalance.controller.response.ResponseCustom;
import com.michelecossu.appbalance.dto.BankAccountDto;
import com.michelecossu.appbalance.service.BankAccountService;
import com.michelecossu.appbalance.service.exception.BankAccountNotFoundException;
import com.michelecossu.appbalance.utils.Costants;

@RestController
@RequestMapping("/bankAccounts")
@CrossOrigin(origins = Costants.BASE_URL, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE}, allowedHeaders = "*")
public class BankAccountController extends BaseController {
	
	private final BankAccountService bankAccountService;
	
	public BankAccountController(BankAccountService contoService) {
		this.bankAccountService = contoService;
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseCustom> getAllBankAccounts() {
		return ResponseEntity.ok(buildSuccessResponse(bankAccountService.getAllBankAccounts()));
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseCustom> getBankAccountById(@PathVariable long id) {
		ResponseCustom response = new ResponseCustom<>();
		
		try {
			response = buildSuccessResponse(bankAccountService.getBankAccountById(id));
			return ResponseEntity.ok(response);
		} catch(BankAccountNotFoundException e) {
			response = buildErrorResponse(400, e.getMessage());
			return ResponseEntity.ok(response);
		}
	}
	
	@DeleteMapping("/deleteBankAccount/{id}")
	public ResponseEntity<ResponseCustom> deleteBankAccountById(@PathVariable long id) {
		ResponseCustom response = new ResponseCustom<>();
		
		try {
			bankAccountService.deleteBankAccountById(id);
			response.setStatus("success");
			response.setPayload("Il Bank Account con l'id " + id + " è stato cancellato correttamente.");
			return ResponseEntity.ok(response);
		} catch(BankAccountNotFoundException e) {
			response = buildErrorResponse(400, e.getMessage());
			return ResponseEntity.ok(response);
		}
	}
	
	@PostMapping(value = "/newBankAccount", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseCustom> saveBankAccount(@RequestBody BankAccountDto bankAccountDto) {
		ResponseCustom response = new ResponseCustom<>();
		
		try {
			response = buildSuccessResponse(bankAccountService.saveBankAccount(bankAccountDto));
			return ResponseEntity.ok(response);
		} catch(BankAccountNotFoundException e) {
			response = buildErrorResponse(400, e.getMessage());
			return ResponseEntity.ok(response);
		}  
	}

}
