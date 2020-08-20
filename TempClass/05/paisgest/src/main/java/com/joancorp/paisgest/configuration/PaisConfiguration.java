package com.joancorp.paisgest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.joancorp.paisgest.services.ClienteService;
import com.joancorp.paisgest.services.impl.ClienteServiceImpl;

@Configuration
public class PaisConfiguration {
	
	@Bean
	public RestTemplate crearRestTemplate() {
		return new RestTemplate();
	}
	@Bean
	public ClienteService crearClienteService() {
		return new ClienteServiceImpl();
	}

	
}
