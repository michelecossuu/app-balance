package com.michelecossu.appbalance.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michelecossu.appbalance.dto.ContoDto;
import com.michelecossu.appbalance.service.ContoService;

@RestController
@RequestMapping("/conti")
@CrossOrigin(origins = "http://localhost:8100")
public class ContoController {
	
	private final ContoService contoService;
	
	public ContoController(ContoService contoService) {
		this.contoService = contoService;
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ContoDto> getAllConti() {
		return contoService.getAllConti();
	}

}
