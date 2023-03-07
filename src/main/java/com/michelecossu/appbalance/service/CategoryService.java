package com.michelecossu.appbalance.service;

import java.util.List;

import com.michelecossu.appbalance.dto.CategoryDto;

public interface CategoryService {
	
	List<CategoryDto> getAllCategories();
	
	CategoryDto getCategoryById(long id);
	
	CategoryDto saveCategory(CategoryDto categoryDto);
	
	void deleteCategoryById(long id);

}
