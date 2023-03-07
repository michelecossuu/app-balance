package com.michelecossu.appbalance.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "transaction_type")
	private String transactionType;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "bank_account_id")
//	private BankAccount bankAccount;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//	private Category category;

}
