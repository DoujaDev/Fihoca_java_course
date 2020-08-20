package com.pgrsoft.demojpa.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.pgrsoft.demojpa.model.Jugador;
import com.pgrsoft.demojpa.services.JugadorServices;

@RestController
public class JugadorController {
	
	@Autowired
	private JugadorServices  jugadorService;
	
	@GetMapping("/jugadores")
	public List<Jugador> getAll(){
		return jugadorService.findAll();
	}
	
	
	@GetMapping("/jugadores/dorsal")
	
	
	public List<Jugador> getByDorsal(@RequestParam(name="dorsal") int dorsal ){
		
		 return jugadorService.findByDorsal(dorsal) ;
		  
	}
	
	
}
