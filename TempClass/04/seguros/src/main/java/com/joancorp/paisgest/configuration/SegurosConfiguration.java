package com.joancorp.paisgest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.joancorp.paisgest.services.SeguroServices;
import com.joancorp.paisgest.services.Impl.SeguroServicesImpl;


@Configuration
public class SegurosConfiguration {

	@Bean
	public SeguroServices crearVehiculoService() {
		return new SeguroServicesImpl();
	}
}
