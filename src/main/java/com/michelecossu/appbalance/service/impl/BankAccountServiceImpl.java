package com.michelecossu.appbalance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.michelecossu.appbalance.dto.ContoDto;
import com.michelecossu.appbalance.model.Conto;
import com.michelecossu.appbalance.repository.ContoRepository;
import com.michelecossu.appbalance.service.ContoService;

@Service
public class ContoServiceImpl implements ContoService{
	
	private final ContoRepository contoRepository;

	public ContoServiceImpl(ContoRepository contoRepository) {
		this.contoRepository = contoRepository;
	}

	@Override
	public List<ContoDto> getAllConti() {
		List<Conto> listaConti = contoRepository.findAll();
		List<ContoDto> listaContiDto = new ArrayList<>();
		ContoDto contoDto = new ContoDto();
		
		if(!listaConti.isEmpty()) {
			listaConti.forEach(conto -> {
				contoDto.setId(conto.getId());
				contoDto.setNome(conto.getNome());
				contoDto.setSaldo(conto.getSaldo());
				listaContiDto.add(contoDto);
			});
		}
		
		return listaContiDto;
	}

}
