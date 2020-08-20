package com.empresaa.paises.services.impl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.empresaa.paises.model.Pais;
import com.empresaa.paises.model.RestPais;
import com.empresaa.paises.services.PaisesServices;


@Service
public class PaisesServicesImpl implements PaisesServices {
	
	private static RestTemplate restTemplate = new RestTemplate();
	private static HttpHeaders headers = new HttpHeaders();
	private static String url = "https://restcountries.eu/rest/v2/";
	
	static {
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
	}
	
	@Override
	public List<Pais> getAll() {
		List<Pais> listaPaises = new ArrayList<Pais>(); 
		
		String resourceURL = url + "all";
		HttpEntity<String> entity = new HttpEntity<String> (headers);
		ResponseEntity<RestPais[]> response = restTemplate.exchange(resourceURL, HttpMethod.GET, entity, RestPais[].class);
		
		if(response.getStatusCode()== HttpStatus.OK) {
			for(RestPais restPais : response.getBody()) {
				Pais respuesta = new Pais();
				respuesta.convert(restPais);
			    listaPaises.add(respuesta);
			}
		} else {
			
			System.out.println("error");
		}
		
		return listaPaises;
	}

	@Override
	public List<Pais> getByNombre(String nombre) {
		List<Pais> listaPaises = new ArrayList<Pais>(); 
		
		String resourceURL = url + "name/" + nombre;
		HttpEntity<String> entity = new HttpEntity<String> (headers);
		ResponseEntity<RestPais[]> response = restTemplate.exchange(resourceURL, HttpMethod.GET, entity, RestPais[].class);
		
		if(response.getStatusCode()== HttpStatus.OK) {
			for(RestPais restPais : response.getBody()) {
				Pais respuesta = new Pais();
				respuesta.convert(restPais);
			    listaPaises.add(respuesta);
			}
		} else {
			
			System.out.println("error");
		}
		
		return listaPaises;
	}
}
	
		


