package org.eduware.seguros.controllers;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;


import org.eduware.seguros.services.SegurosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SegurosControllers {
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
	
		
	@Autowired
	private SegurosServices segurosServices;
	
	@GetMapping("/seguro")
	public Map<String,Double> getSeguro(@RequestParam("marca") String marca,
										@RequestParam("modelo") String modelo,
										@RequestParam("color") String color,
										@RequestParam("tipo") Tipo tipo,
										@RequestParam("nacimiento") String nacimientoStr,
										@RequestParam("carnet") String carnetStr) throws org.apache.tomcat.util.json.ParseException {
		LocalDate nacimiento = null;
		LocalDate carnet = null;
		
		try {
			nacimiento = LocalDate.parse(nacimientoStr, formatter);
			carnet = LocalDate.parse(carnetStr, formatter);
		} catch (Exception e) {
			throw new org.apache.tomcat.util.json.ParseException("Error. El formato de la fecha debe ser dd/MM/yyyy");
		}
		 
		return segurosServices.getSeguro(marca, modelo, color, tipo, nacimiento, carnet);
	}
	/*
	@PostMapping("/coches")
	public Map<String,Map<String,Double>> create(@RequestBody Map<String,Map<String,Double>> coche) {
		return segurosServices.createCoche(coche);
	}
	*/

}
