package org.eduware.infragest.backend.controllers;

import java.util.List;
import java.util.Map;

import org.eduware.infragest.backend.model.Multa;
import org.eduware.infragest.backend.services.MultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultaController {
	
	@Autowired
	private MultaService MultaService;
	
	// Obtener multas por nombre de agente
	@GetMapping("/multas")
	public List<Multa> getMultas(@RequestParam Map<String,String> allParams){
		if (allParams.containsKey("agente")) {
			return MultaService.getByAgente(allParams.get("agente"));
		}
		else if (allParams.containsKey("min") && allParams.containsKey("max")) {
			return MultaService.getByPriceRange(Integer.parseInt(allParams.get("min")), 
												Integer.parseInt(allParams.get("max")));
		} else {
		return MultaService.getAll();
	}
	}
	
	// Crear nueva multa
	@PostMapping("/multas")
	public Multa create(Multa multa) {
		return MultaService.create(multa);
	}
	
	// Eliminar
	@DeleteMapping("/multas/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable("id")Integer codigo) {
		MultaService.delete(codigo);
	}
	
	// Obtener multa por codigo
	@GetMapping("/multas/{id}")
	public Multa getByCodigo(@PathVariable("id") Integer codigo) {
		System.out.println("entramos");
		return MultaService.getByCodigo(codigo);
	}
	
	// Obtener multas top cantidad
	@GetMapping("/multas/topImporte")
	public List<String> getTopImporte(){
		return MultaService.getTopImporte();
	}
	
	// Obtener multas top importe
	@GetMapping("/multas/topCantidad")
	public List<String> getTopCantidad(){
		return MultaService.getTopCantidad();
	}
	
	

	
	
	
	
	
}
