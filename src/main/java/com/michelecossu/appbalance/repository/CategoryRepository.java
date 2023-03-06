package com.michelecossu.appbalance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michelecossu.appbalance.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	List<Category> findAll();

}
