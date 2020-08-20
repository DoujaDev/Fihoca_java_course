package com.pgrsoft.demojpa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.demojpa.model.Multa;
import com.pgrsoft.demojpa.services.MultaServices;


@RestController
public class MultaController {
	
	@Autowired
	private MultaServices multaServices;
	
	// 1.- endpoint
	
	@GetMapping("/multas")
	public List<Multa> getAll(){
		return multaServices.findAll();
	}
	
	// 2.- endpoint
	
	@GetMapping("/multas/{code}")
	public Multa getByCode(@PathVariable("code") Long codigo) {
		
		Optional<Multa> optional = multaServices.findById(codigo);
	
		 Multa  multa= null;
		
		if(optional.isPresent()) {
			multa = optional.get();
		}
		
		return multa;
		
		//return optional.isPresent()? optional.get() : null;
	}
	
	// 3.- endpoint
	
	@PostMapping("/multas")
	public Multa crear(@RequestBody Multa multa) {
		return multaServices.save(multa);
	}
	
	
	// 4.- endpoint
	
	@DeleteMapping("/multas/{code}")
	public String eliminar(@PathVariable("code") Long codigo) {
		
		multaServices.deleteById(codigo);
		
		return "ok, producto " + codigo + "liminado";
	}
	
	// 5.- endpoint
	
	@PutMapping("/multas")
	public Multa actualizar(@RequestBody Multa multa) {
		
		// El producto que actualizamos debe tener una ID en el sistema!
		
		return multaServices.save(multa);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
