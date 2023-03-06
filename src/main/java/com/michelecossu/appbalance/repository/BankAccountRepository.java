package com.michelecossu.appbalance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michelecossu.appbalance.model.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{
	
	List<BankAccount> findAll();
	
}
