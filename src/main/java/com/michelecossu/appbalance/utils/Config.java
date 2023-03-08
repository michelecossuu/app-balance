package com.michelecossu.appbalance.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean
    public Costants costants() {
        return new Costants();
    }
	
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
