package com.michelecossu.appbalance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.michelecossu.appbalance.dto.CategoryDto;
import com.michelecossu.appbalance.model.Category;
import com.michelecossu.appbalance.repository.CategoryRepository;
import com.michelecossu.appbalance.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoriaRepository) {
		this.categoryRepository = categoriaRepository;
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> categoryList = categoryRepository.findAll();
		List<CategoryDto> categoryListDto = new ArrayList<>();
		CategoryDto categoryDto = new CategoryDto();
		
		if(!categoryList.isEmpty()) {
			categoryList.forEach(category -> {
				categoryDto.setId(category.getId());
				categoryDto.setName(category.getName());
				categoryListDto.add(categoryDto);
			});
		}
		
		return categoryListDto;
	}

}
