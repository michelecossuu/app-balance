package com.michelecossu.appbalance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContoDto {
	
	private long id;
	private String nome;
	private double saldo;
	
}
