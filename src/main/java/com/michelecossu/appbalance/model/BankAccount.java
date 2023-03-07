package com.michelecossu.appbalance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_account")
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "balance")
	private double balance;
	
//	@OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Transaction> transactions = new ArrayList<>();

}
