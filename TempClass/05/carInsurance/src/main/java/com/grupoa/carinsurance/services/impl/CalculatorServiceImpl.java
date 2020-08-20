package com.grupoa.carinsurance.services.impl;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.grupoa.carinsurance.services.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	private static final double BASE = 20;
	
	private static final Map<String, Double> modelos = new HashMap<String, Double>();
	private static final Map<String, Double> colores = new HashMap<String, Double>();
	private static final Map<String, Double> precioTipo = new HashMap<String, Double>();
	
	static {
		
		modelos.put("SeatIbiza", 1.0);
		modelos.put("SeatLeon", 2.0);
		modelos.put("SeatArona", 3.0);
		
		modelos.put("AudiA1",1.0);
		modelos.put("AudiA2",2.0);
		modelos.put("AudiA3",3.0);
		
		modelos.put("FerrariCalifornia", 1.0);
		modelos.put("FerrariFF", 2.0);
		modelos.put("Ferrari612", 3.0);
		
		///////////////////////////////////////
		
		colores.put("Blanco",1.0);
		colores.put("Azul",2.0);
		colores.put("Rojo",3.0);
		colores.put("Rosa",4.0);
		colores.put("Negro",5.0);
		
		///////////////////////////////////////
		
		precioTipo.put("SegundaMano", 1.0);
		precioTipo.put("Km0", 2.0);
		precioTipo.put("Nuevo", 3.0);
		
	}
	
	@Override
	public double getPrice(String marca, String modelo, String color, String tipo, Date fechaNacimiento,
			Date fechaCarnet) {
		
		String codigo = marca+modelo;
		
		double coffModelo = modelos.get(codigo);
		double coffColor = colores.get(color);
		double coffTipo = precioTipo.get(tipo);
		double coffEdad = 0.0;
		double coffAntiguedad = 0.0;
		
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		LocalDate diaActual = LocalDate.now();
		//LocalDate nacimiento = LocalDate.of(2018, Month.JANUARY, 8);
		LocalDate nacimiento = fechaNacimiento.toInstant().
				atZone(ZoneId.systemDefault()).
				toLocalDate();
		LocalDate carnet = fechaCarnet.toInstant().
				atZone(ZoneId.systemDefault()).
				toLocalDate();
		
		long edad = ChronoUnit.DAYS.between(nacimiento, diaActual);
		
		if(edad<18) {
			// throw new Exception("debe ser mayor de edad ");
		}else if (edad>=18 && edad < 35) {
			coffEdad = 3.0;
			
		} else if (edad>=35 && edad <60) {
			coffEdad = 2.0;
			
		} else {
			coffEdad = 3.0;
		}
		
		long antiguedad = ChronoUnit.DAYS.between(carnet, diaActual);
		
		if(antiguedad<0) {
			// throw new Exception("debe ser mayor de edad ");
		}else if (antiguedad < 2) {
			coffAntiguedad = 3.0;
			
		} else if (antiguedad>=2 && antiguedad <10) {
			coffAntiguedad = 2.0;
			
		} else {
			coffAntiguedad = 3.0;
		}
		
		
		double precio = BASE + 1*coffModelo + 1*coffColor + 1*coffTipo + 1*coffEdad + 1*coffAntiguedad ; 
		
		return precio;
	}

}