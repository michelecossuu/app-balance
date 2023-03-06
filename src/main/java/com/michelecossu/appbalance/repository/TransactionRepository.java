package com.michelecossu.appbalance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michelecossu.appbalance.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	List<Transaction> findAll();

}
