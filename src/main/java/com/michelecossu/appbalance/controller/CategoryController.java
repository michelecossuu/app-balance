package com.michelecossu.appbalance.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michelecossu.appbalance.dto.CategoryDto;
import com.michelecossu.appbalance.service.CategoryService;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:8100")
public class CategoryController {
	
	private final CategoryService categoriaService;

	public CategoryController(CategoryService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CategoryDto> getAllCategories() {
		return categoriaService.getAllCategories();
	}
	
	//TODO saveCategory
	
	//TODO getCategoryById
	
	//TODO deleteCategoryById

}
