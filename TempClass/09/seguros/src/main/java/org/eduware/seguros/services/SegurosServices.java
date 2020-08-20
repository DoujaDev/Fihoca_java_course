package org.eduware.seguros.services;

import java.time.LocalDate;
import java.util.Map;

import org.eduware.seguros.controllers.Tipo;

public interface SegurosServices {
	
	public Map<String,Double> getSeguro(String marca, String modelo, String color, Tipo tipo, LocalDate nacimiento, LocalDate carnet );

	//public Map<String,Map<String,Double>> createCoche(Map<String,Map<String,Double>> coche);
}
