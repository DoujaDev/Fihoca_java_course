package com.projectclick.gestionsegurosvehiculo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectclick.gestionsegurosvehiculo.model.Tipo;
import com.projectclick.gestionsegurosvehiculo.model.Vehiculo;
import com.projectclick.gestionsegurosvehiculo.services.GestionSeguro;

@RestController
@RequestMapping("/api/vehiculo")
public class SeguroController {
	
	@Autowired
	private GestionSeguro gestionSeguro;
	
	@GetMapping("/precio")
	public double precio (	@RequestParam(value = "codigo")Integer codigo, 
							@RequestParam(value = "marca")String marca,
							@RequestParam(value = "modelo")String modelo, 
							@RequestParam(value = "color")String color,
							@RequestParam(value = "tipo")Tipo tipo, 
							@RequestParam(value = "fechaNacimiento")Date fechaNacimiento,
							@RequestParam(value = "fechaCarnet")Date fechaCarnet ) {
	
		System.out.println(fechaNacimiento);
		
		if(marca.equals("") || modelo.equals("") || color.equals("") || tipo == null) {
		
		throw new RuntimeException("Campo Vacio");
		
	}else{
	
		Vehiculo vehiculo = new Vehiculo(codigo, marca, modelo, color, tipo, fechaNacimiento, fechaCarnet);
		
		return gestionSeguro.getSeguroPrecio(vehiculo);
		
		}
	}
	@GetMapping("")
	public List<Vehiculo> getAll(){
		
		return gestionSeguro.getAll();
	}
	
	@PostMapping("/create")
	public Vehiculo create(@RequestBody Vehiculo vehiculo) {
		
		return gestionSeguro.create(vehiculo);	
	}
}
