package com.michelecossu.appbalance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michelecossu.appbalance.model.Conto;

public interface ContoRepository extends JpaRepository<Conto, Long>{
	
	List<Conto> findAll();
	
}
