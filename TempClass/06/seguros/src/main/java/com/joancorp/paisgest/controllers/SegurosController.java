package com.joancorp.paisgest.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joancorp.paisgest.model.Color;
import com.joancorp.paisgest.model.Tipo;
import com.joancorp.paisgest.services.VehiculoServices;

@RestController
@RequestMapping("/api/seguros")
public class SegurosController {

	@Autowired
	private VehiculoServices vehiculoService;
	
	@GetMapping
	public PrecioDTO getPrecio(@RequestParam("marca") String marca, 
							   @RequestParam("modelo") String modelo,
							   @RequestParam("color") Color color,
							   @RequestParam("tipo") Tipo tipo,
							   @RequestParam("fechanacimiento") LocalDate fechaNacimiento,
							   @RequestParam("fechaCarnet") LocalDate fechaCarnet) {
		
		PrecioDTO precio = vehiculoService.getPrecio(new Vehiculo(), 
													tipo, 
													color, 
													cliente));
		
		return precio;
		
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
