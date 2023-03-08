package com.michelecossu.appbalance.repository;

import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.michelecossu.appbalance.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	@Query(value = "SELECT t FROM Transaction t WHERE t.id = :id")
	Transaction findById(long id);
	
	@Query(value = "SELECT t FROM Transaction t WHERE t.bankAccount.id = :id")
	List<Transaction> findAllByBankAccountId(long id);

	@Query(value = "SELECT t FROM Transaction t WHERE t.bankAccount.id = :bankAccountId AND t.category.id = :categoryId")
	List<Transaction> findAllByBankAccountIdAndCategoryId(long bankAccountId, long categoryId);
	
}
