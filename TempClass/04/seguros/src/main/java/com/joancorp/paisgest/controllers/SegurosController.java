package com.joancorp.paisgest.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joancorp.paisgest.controllers.exception.GlobalExceptionHandler;
import com.joancorp.paisgest.model.Tipo;
import com.joancorp.paisgest.services.SeguroServices;

@RestController
@RequestMapping("/api/seguros")
public class SegurosController {

	@Autowired
	private SeguroServices vehiculoService;
	
	@GetMapping
	public PrecioDTO calculatePrice(@RequestParam("marca") String marca, 
							   @RequestParam("modelo") String modelo,
							   @RequestParam("color") String color,
							   @RequestParam("tipo") Tipo tipo,
							   @RequestParam("fechanacimiento") String fNacimiento,
							   @RequestParam("fechacarnet") String fCarnet){
		
		LocalDate fechaNacimiento = LocalDate.parse(fNacimiento);
		LocalDate fechaCarnet = LocalDate.parse(fCarnet);
		
		double precio = 0.0;
		
		precio = vehiculoService.calculatePrice(marca, modelo, color, tipo, fechaNacimiento, fechaCarnet);
		
		return new PrecioDTO(precio);
	}
	
	class PrecioDTO
	{
		private double precio;
		
		public PrecioDTO(double precio) {
			this.precio = precio;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}
		
	}
	
	
}
