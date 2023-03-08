package com.michelecossu.appbalance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.michelecossu.appbalance.dto.CategoryDto;
import com.michelecossu.appbalance.model.Category;
import com.michelecossu.appbalance.repository.CategoryRepository;
import com.michelecossu.appbalance.service.CategoryService;
import com.michelecossu.appbalance.service.exception.CategoryNotFoundException;
import com.michelecossu.appbalance.utils.ModelMapper;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryRepository categoryRepository;
	private ModelMapper mapper;
    private static final Logger logger = LogManager.getLogger(CategoryServiceImpl.class);

	public CategoryServiceImpl(CategoryRepository categoriaRepository, ModelMapper mapper) {
		this.categoryRepository = categoriaRepository;
		this.mapper = mapper;
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> categoryList = categoryRepository.findAll();
		List<CategoryDto> categoryListDto = new ArrayList<>();
		
		if(!categoryList.isEmpty()) {
			categoryList.forEach(category -> {
				CategoryDto categoryDto = new CategoryDto();
				categoryDto.setId(category.getId());
				categoryDto.setName(category.getName());
				categoryListDto.add(categoryDto);
			});
		}
		
		return categoryListDto;
	}

	@Override
	public CategoryDto getCategoryById(long id) {
		Category category = categoryRepository.findById(id);
		
		if(category == null) throw new CategoryNotFoundException("Il BankAccount con l'id " + id + " non esiste.");
		
		return mapper.categoryToCategoryDto(category);
	}

	@Override
	public CategoryDto saveCategory(CategoryDto categoryDto) {
		logger.info("saveBankAccount - inizio metodo");
		
		if(categoryDto == null) throw new CategoryNotFoundException("Il BankAccountDto non è corretto.");
		
		Category category = categoryRepository.save(mapper.categoryDtoToCategory(categoryDto));
		categoryDto.setId(category.getId());
				
		logger.info("saveBankAccount - fine metodo");
				
		return categoryDto;
	}

	@Override
	public void deleteCategoryById(long id) {
		Category category = categoryRepository.findById(id);

		if(category == null) throw new CategoryNotFoundException("Il BankAccount con l'id " + id + " non esiste.");

		categoryRepository.deleteById(id);		
	}

}
