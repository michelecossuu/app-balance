package com.michelecossu.appbalance.controller;

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

import com.michelecossu.appbalance.controller.response.ResponseCustom;
import com.michelecossu.appbalance.dto.CategoryDto;
import com.michelecossu.appbalance.service.CategoryService;
import com.michelecossu.appbalance.service.exception.CategoryNotFoundException;
import com.michelecossu.appbalance.utils.Costants;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = Costants.BASE_URL)
public class CategoryController extends BaseController{
	
	private final CategoryService categoryService;

	public CategoryController(CategoryService categoriaService) {
		this.categoryService = categoriaService;
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseCustom> getAllCategories() {
		return ResponseEntity.ok(buildSuccessResponse(categoryService.getAllCategories()));
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseCustom> getCategoryById(@PathVariable long id) {
		ResponseCustom response = new ResponseCustom<>();
		
		try {
			response = buildSuccessResponse(categoryService.getCategoryById(id));
			return ResponseEntity.ok(response);
		} catch(CategoryNotFoundException e) {
			response = buildErrorResponse(400, e.getMessage());
			return ResponseEntity.ok(response);
		}	}
	
	@DeleteMapping("/deleteCategory/{id}")
	public ResponseEntity<ResponseCustom> deleteCategoryById(@PathVariable long id) {
		ResponseCustom response = new ResponseCustom<>();
		
		try {
			categoryService.deleteCategoryById(id);
			response.setStatus("success");
			response.setPayload("La Category con l'id " + id + " è stata cancellata correttamente.");
			return ResponseEntity.ok(response);
		} catch(CategoryNotFoundException e) {
			response = buildErrorResponse(400, e.getMessage());
			return ResponseEntity.ok(response);
		}
	}
	
	@PostMapping(value = "/newCategory", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseCustom> saveCategory(@RequestBody CategoryDto categoryDto) {
		ResponseCustom response = new ResponseCustom<>();
		
		try {
			response = buildSuccessResponse(categoryService.saveCategory(categoryDto));
			return ResponseEntity.ok(response);
		} catch(CategoryNotFoundException e) {
			response = buildErrorResponse(400, e.getMessage());
			return ResponseEntity.ok(response);
		}  
	}

}
