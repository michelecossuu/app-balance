package com.michelecossu.appbalance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.michelecossu.appbalance.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	@Query(value = "SELECT c FROM Category c WHERE c.id = :id")
	Category findById(long id);

}
