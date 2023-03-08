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
import org.springframework.web.bind.annotation.RestController;

import com.michelecossu.appbalance.controller.response.ResponseCustom;
import com.michelecossu.appbalance.dto.TransactionDto;
import com.michelecossu.appbalance.service.TransactionService;
import com.michelecossu.appbalance.service.exception.BankAccountNotFoundException;
import com.michelecossu.appbalance.service.exception.CategoryNotFoundException;
import com.michelecossu.appbalance.service.exception.TransactionNotFoundException;
import com.michelecossu.appbalance.utils.Costants;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = Costants.BASE_URL)
public class TransactionController extends BaseController {
	
	private final TransactionService transactionService;

	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseCustom> getAllTransactions() {
		return ResponseEntity.ok(buildSuccessResponse(transactionService.getAllTransactions()));
	}
	
	@GetMapping(value = "/all/bankAccounts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseCustom> getAllTransactionByBankAccount(@PathVariable long id) {
		return ResponseEntity.ok(buildSuccessResponse(transactionService.getAllTransactionByBankAccount(id)));
	}
		
	@GetMapping(value="all/bankAccounts/{bankAccountId}/categories/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseCustom> getAllTransactionByBankAccountAndCategory(@PathVariable long bankAccountId, @PathVariable long categoryId) {
		return ResponseEntity.ok(buildSuccessResponse(transactionService.getAllTransactionByBankAccountAndCategory(bankAccountId, categoryId)));
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseCustom> getTransactionById(@PathVariable long id) {
		ResponseCustom response = new ResponseCustom<>();
		
		try {
			response = buildSuccessResponse(transactionService.getTransactionById(id));
			return ResponseEntity.ok(response);
		} catch(TransactionNotFoundException e) {
			response = buildErrorResponse(400, e.getMessage());
			return ResponseEntity.ok(response);
		}
	}
	
	@PostMapping(value = "/newTransaction", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseCustom> saveTransaction(@RequestBody TransactionDto transactionDto) {
		ResponseCustom response = new ResponseCustom<>();
		
		try {
			response = buildSuccessResponse(transactionService.saveTransaction(transactionDto));
			return ResponseEntity.ok(response);
		} catch(TransactionNotFoundException | BankAccountNotFoundException | CategoryNotFoundException e) {
			response = buildErrorResponse(400, e.getMessage());
			return ResponseEntity.ok(response);
		}  
	}

	@DeleteMapping("/deleteTransaction/{id}")
	public ResponseEntity<ResponseCustom> deleteTransactionById(@PathVariable long id) {
		ResponseCustom response = new ResponseCustom<>();
		
		try {
			transactionService.deleteTransactionById(id);
			response.setStatus("success");
			response.setPayload("La transazione con l'id " + id + " è stata cancellata correttamente.");
			return ResponseEntity.ok(response);
		} catch(TransactionNotFoundException e) {
			response = buildErrorResponse(400, e.getMessage());
			return ResponseEntity.ok(response);
		}
	}
}
