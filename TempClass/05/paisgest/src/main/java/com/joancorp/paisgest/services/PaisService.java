package com.joancorp.paisgest.services;

import java.util.List;

import com.joancorp.paisgest.model.Pais;

public interface PaisService {
	
	public List<Pais> getAll();
	
	public List<Pais> getByCountryName(String name);
	

}
