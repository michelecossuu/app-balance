package com.michelecossu.appbalance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conto")
public class Conto {
	
	@Id
	@Column(name= "id")
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "saldo")
	private double saldo;

}
