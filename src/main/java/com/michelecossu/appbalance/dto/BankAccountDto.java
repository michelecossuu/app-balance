package com.michelecossu.appbalance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDto {
	
	private long id;
	private String name;
	private double balance;
	
}
