package com.joancorp.paisgest.services.Impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

import com.joancorp.paisgest.model.Cliente;
import com.joancorp.paisgest.model.Color;
import com.joancorp.paisgest.model.Tipo;
import com.joancorp.paisgest.model.Vehiculo;
import com.joancorp.paisgest.services.VehiculoServices;


public class VehiculoServicesImpl implements VehiculoServices {


	@Override
	public Map<String, Double> getPrecio(Vehiculo vehiculo, Tipo tipo, Color color, Cliente cliente) {
		
		double precio = vehiculo.preciosBase.get(vehiculo);
		precio += tipo.getCoeficiente()*precio;
		precio += color.getCoeficiente()*precio;		
		
		LocalDate fechaActual = LocalDate.now();
		
		int edad = Period.between(cliente.getFechaNacimiento(), fechaActual).getYears();
		int antiguedad = Period.between(cliente.getFechaCarnet(), fechaActual).getYears();
		
		if (edad < 18) {
			throw new RuntimeException("Madura y vuelve");
		}
		
		else if (18 < edad && edad < 22) {
			precio += 0.5*precio;
		}
		
		if (antiguedad < 0) {
			throw new RuntimeException("Madura y vuelve");
		}
		
		else if (antiguedad < 3) {
			precio += 0.5*precio;
		}
		
		Map<String, Double> precioMap = new HashMap<String, Double>();
		precioMap.put("precio: ", precio);
		
		return precioMap;
	}

}
