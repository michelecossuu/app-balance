package com.michelecossu.appbalance.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean
    public Common commons() {
        return new Common();
    }

}
