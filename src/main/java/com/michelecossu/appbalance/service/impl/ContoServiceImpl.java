package com.michelecossu.appbalance.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

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
	public List<Conto> getAllConti() {
		return contoRepository.findAll();
	}

}
