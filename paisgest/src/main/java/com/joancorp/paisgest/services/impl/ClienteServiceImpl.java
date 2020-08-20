package com.joancorp.paisgest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.joancorp.paisgest.model.PaisRest;
import com.joancorp.paisgest.services.ClienteService;

public class ClienteServiceImpl implements ClienteService {
	
	private static final String URL;
	
	@Autowired
	private RestTemplate restTemplate;
	
	static {
		URL = "https://restcountries.eu/rest/v2/";
	}
	@Override
	public PaisRest[] getAll() {
		
		ResponseEntity<PaisRest[]> response = 
					restTemplate.getForEntity(URL, PaisRest[].class);
		
		return response.getBody();
	}
	
	@Override
	public PaisRest[] getByCountryName(String name) {
		
		ResponseEntity<PaisRest[]> response = 
				restTemplate.getForEntity(URL + "name/" + name, PaisRest[].class);
		return response.getBody();
	
	}
	
}
