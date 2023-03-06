package com.michelecossu.appbalance.db;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.michelecossu.appbalance.repository")
public class DatabaseConfig {
 
    
}
