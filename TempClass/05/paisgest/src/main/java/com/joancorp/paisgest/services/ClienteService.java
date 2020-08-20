package com.joancorp.paisgest.services;

import com.joancorp.paisgest.model.PaisRest;

public interface ClienteService {
	
	public PaisRest[] getAll();
	
	public PaisRest[] getByCountryName(String name);
}
