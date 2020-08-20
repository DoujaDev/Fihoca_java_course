package com.joancorp.paisgest.services;

import java.time.LocalDate;

import com.joancorp.paisgest.model.Tipo;
import com.joancorp.paisgest.model.Vehiculo;

public interface SeguroServices {

	double calculatePrice(Vehiculo vehiculo, String color, Tipo tipo, LocalDate fechaNacimiento, LocalDate fechaCarnet);

	double calculatePrice(int codigoVehiculo, String color, Tipo tipo, LocalDate fechaNacimiento, LocalDate fechaCarnet);

	double calculatePrice(String marca, String modelo, String color, Tipo tipo, LocalDate fechaNacimiento, LocalDate fechaCarnet);

	/*
	public double calculatePrice(Vehiculo vehiculo, 
											Tipo tipo, 
											Color color, 
											Cliente cliente);
	*/

}
