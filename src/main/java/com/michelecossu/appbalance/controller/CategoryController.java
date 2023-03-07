package com.michelecossu.appbalance.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michelecossu.appbalance.dto.BankAccountDto;
import com.michelecossu.appbalance.dto.CategoryDto;
import com.michelecossu.appbalance.service.CategoryService;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:8100")
public class CategoryController {
	
	private final CategoryService categoryService;

	public CategoryController(CategoryService categoriaService) {
		this.categoryService = categoriaService;
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryDto>> getAllCategories() {
		return ResponseEntity.ok(categoryService.getAllCategories());
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable long id) {
		return ResponseEntity.ok(categoryService.getCategoryById(id));
	}
	
	@DeleteMapping("/deleteCategory/{id}")
	public ResponseEntity<String> deleteCategoryById(@PathVariable long id) {
		categoryService.deleteCategoryById(id);
		String response = "La categoria con l'id " + id + " è stato cancellato correttamente.";
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/newCategory", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto) {
		return ResponseEntity.ok(categoryService.saveCategory(categoryDto));
	}

}
