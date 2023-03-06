package com.michelecossu.appbalance.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michelecossu.appbalance.dto.CategoriaDto;
import com.michelecossu.appbalance.service.CategoriaService;

@RestController
@RequestMapping("/categorie")
@CrossOrigin(origins = "http://localhost:8100")
public class CategoriaController {
	
	private final CategoriaService categoriaService;

	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CategoriaDto> getAllCategorie() {
		return categoriaService.getAllCategorie();
	}

}
