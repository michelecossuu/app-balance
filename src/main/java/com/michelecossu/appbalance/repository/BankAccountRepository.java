package com.michelecossu.appbalance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.michelecossu.appbalance.model.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{
	
	@Query(value = "SELECT ba FROM BankAccount ba WHERE ba.id = :id")
	BankAccount findById(long id);
	
	
}
