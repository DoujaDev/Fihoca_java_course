package com.empresaa.paises.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.empresaa.paises.model.Pais;


@RestController
public class PaisesControllers {
	
	@Autowired	
	private com.empresaa.paises.services.PaisesServices paisesServices;
	
	@GetMapping ("/paises")
	public List<Pais> getAll (){
		return paisesServices.getAll();
	}

	@GetMapping("/paises/{nombre}")
	public List<Pais> getByNombre(@PathVariable("nombre") String nombre) {
		System.out.println("Aqui esta el país requerido");
		return paisesServices.getByNombre(nombre);
	}
	
	
	
}
