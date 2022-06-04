package com.jefferson.cursomc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jefferson.cursomc.service.EmailService;
import com.jefferson.cursomc.service.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}

}
