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
import com.michelecossu.appbalance.service.exception.BankAccountNotFound;
import com.michelecossu.appbalance.service.exception.CategoryNotFound;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryRepository categoryRepository;
    private static final Logger logger = LogManager.getLogger(CategoryServiceImpl.class);

	public CategoryServiceImpl(CategoryRepository categoriaRepository) {
		this.categoryRepository = categoriaRepository;
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
		
		if(category == null) throw new CategoryNotFound("Il BankAccount con l'id " + id + " non esiste.");
		
		return categoryToCategoryDto(category);
	}

	@Override
	public CategoryDto saveCategory(CategoryDto categoryDto) {
		logger.info("saveBankAccount - inizio metodo");
		
		if(categoryDto == null) throw new CategoryNotFound("Il BankAccountDto non è corretto.");
		
		Category category = categoryRepository.save(categoryDtoToCategory(categoryDto));
		categoryDto.setId(category.getId());
				
		logger.info("saveBankAccount - fine metodo");
				
		return categoryDto;
	}

	@Override
	public void deleteCategoryById(long id) {
		Category category = categoryRepository.findById(id);

		if(category == null) throw new CategoryNotFound("Il BankAccount con l'id " + id + " non esiste.");

		categoryRepository.deleteById(id);		
	}
	
	private CategoryDto categoryToCategoryDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();

		categoryDto.setId(category.getId());
		categoryDto.setName(category.getName());
		
		return categoryDto;
	}
	
	private Category categoryDtoToCategory(CategoryDto categoryDto) {
		Category category = new Category();
		
		logger.info("bankAccountDtoToBankAccount - inizio metodo");
		
		if(categoryDto == null) throw new BankAccountNotFound("Il BankAccountDto non esiste.");
			
		category.setName(categoryDto.getName());
		
		logger.info("bankAccountDtoToBankAccount - fine metodo");
		
		return category;
	}

}
