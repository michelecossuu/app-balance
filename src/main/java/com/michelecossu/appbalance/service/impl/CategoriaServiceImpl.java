package com.michelecossu.appbalance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.michelecossu.appbalance.dto.CategoriaDto;
import com.michelecossu.appbalance.model.Categoria;
import com.michelecossu.appbalance.repository.CategoriaRepository;
import com.michelecossu.appbalance.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	private final CategoriaRepository categoriaRepository;

	public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public List<CategoriaDto> getAllCategorie() {
		List<Categoria> listaCategorie = categoriaRepository.findAll();
		List<CategoriaDto> listaCategoriaDto = new ArrayList<>();
		CategoriaDto categoriaDto = new CategoriaDto();
		
		if(!listaCategorie.isEmpty()) {
			listaCategorie.forEach(categoria -> {
				categoriaDto.setId(categoria.getId());
				categoriaDto.setNome(categoria.getNome());
				listaCategoriaDto.add(categoriaDto);
			});
		}
		
		return listaCategoriaDto;
	}

}
