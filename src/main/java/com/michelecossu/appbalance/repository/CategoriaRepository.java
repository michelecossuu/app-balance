package com.michelecossu.appbalance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michelecossu.appbalance.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	List<Categoria> findAll();

}
