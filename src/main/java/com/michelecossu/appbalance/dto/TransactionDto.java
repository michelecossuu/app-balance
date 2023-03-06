package com.michelecossu.appbalance.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
	
	private long id;
	private String description;
	private Date date;
	private String transactionType;
	private BankAccountDto bankAccount;
	private CategoryDto category;

}
