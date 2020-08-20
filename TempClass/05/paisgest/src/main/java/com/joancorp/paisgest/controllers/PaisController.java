package com.joancorp.paisgest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joancorp.paisgest.model.Pais;
import com.joancorp.paisgest.services.PaisService;

@RestController
@RequestMapping("api/paises")
public class PaisController {
	
	@Autowired
	private PaisService paisService;
	
	@GetMapping("")
	public List<Pais> getAll() {
		
		return paisService.getAll();
	}
	
	@GetMapping("/{name}")
	public List<Pais> getByCountryName(@PathVariable(value="name") String name) {
		
		return paisService.getByCountryName(name);
	}
}
