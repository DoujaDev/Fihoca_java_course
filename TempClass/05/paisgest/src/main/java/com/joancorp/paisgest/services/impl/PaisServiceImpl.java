package com.joancorp.paisgest.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joancorp.paisgest.model.Pais;
import com.joancorp.paisgest.model.PaisRest;
import com.joancorp.paisgest.services.ClienteService;
import com.joancorp.paisgest.services.PaisService;

@Service
public class PaisServiceImpl implements PaisService {

	@Autowired
	private ClienteService clienteService;
	
	@Override
	public List<Pais> getAll() {
		List<PaisRest> paisesRest = Arrays.asList(clienteService.getAll());
		List<Pais> paises = new ArrayList<Pais>();
		
		for(PaisRest paisRest: paisesRest) {
			Pais pais = new Pais(
					paisRest.getName(),
					paisRest.getCapital(),
					paisRest.getBorders().length,
					paisRest.getLanguages().length,
					paisRest.getPopulation());
			
			paises.add(pais);
		}
		
		return paises;
	}

	@Override
	public List<Pais> getByCountryName(String name) {
		List<PaisRest> paisesRest = Arrays.asList(clienteService.getByCountryName(name));
		List<Pais> paises = new ArrayList<Pais>();
		
		for(PaisRest paisRest: paisesRest) {
			Pais pais = new Pais(
					paisRest.getName(),
					paisRest.getCapital(),
					paisRest.getBorders().length,
					paisRest.getLanguages().length,
					paisRest.getPopulation());
			
			paises.add(pais);
		}
		
		return paises;
	}

}
