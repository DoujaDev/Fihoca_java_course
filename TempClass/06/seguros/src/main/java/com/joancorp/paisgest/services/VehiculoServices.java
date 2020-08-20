package com.joancorp.paisgest.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.joancorp.paisgest.model.Cliente;
import com.joancorp.paisgest.model.Color;
import com.joancorp.paisgest.model.Tipo;
import com.joancorp.paisgest.model.Vehiculo;

@Service
public interface VehiculoServices {

	public Map<String, Double> getPrecio(Vehiculo vehiculo, 
											Tipo tipo, 
											Color color, 
											Cliente cliente);
}
