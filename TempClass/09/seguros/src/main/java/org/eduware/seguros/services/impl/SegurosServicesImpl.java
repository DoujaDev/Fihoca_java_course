package org.eduware.seguros.services.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.eduware.seguros.controllers.Tipo;
import org.eduware.seguros.services.SegurosServices;
import org.springframework.stereotype.Service;

@Service
public class SegurosServicesImpl implements SegurosServices {
		
	//private static final Map<String,Double> MARCAS = new HashMap<>();
	//private static final Map<String,Double> MODELOS = new HashMap<>();
	
	
	private static final Map<String,Map<String,Double>> COCHES = new HashMap<>();
	
	private static final Map<String,Double> SEATS = new HashMap<>();
	private static final Map<String,Double> AUDIS = new HashMap<>();
	private static final Map<String,Double> BMWS = new HashMap<>();
	private static final Map<String,Double> PORSCHES = new HashMap<>();
	private static final Map<String,Double> DACIAS = new HashMap<>();
	
	private static final Map<String,Double> COLORES = new HashMap<>();
	private static final Map<Tipo,Double> TIPOS = new HashMap<>();
	private static final Map<Double,Double> EDADES = new HashMap<>();
	private static final Map<Double,Double> CARNETS = new HashMap<>();
	
	
	private static final Double seguroBase = 250.0; 
	
	static {	
		/*
		MARCAS.put("Seat",1.02);
		MARCAS.put("Audi",1.08);
		MARCAS.put("BMW",1.1);
		MARCAS.put("Porsche",1.4);
		MARCAS.put("Dacia",0.8);
		*/
		SEATS.put("Leon",1.08);
		SEATS.put("Ibiza",1.06);
		AUDIS.put("A3",1.12);
		AUDIS.put("A7",1.14);
		BMWS.put("120i",1.18);
		BMWS.put("X3",1.23);
		PORSCHES.put("Carrera",1.70);
		PORSCHES.put("Cayenne",1.80);
		DACIAS.put("Logan",1.01);
		DACIAS.put("Duster",1.03);
		
		COCHES.put("Seat",SEATS);
		COCHES.put("Audi",AUDIS);
		COCHES.put("BMW",BMWS);
		COCHES.put("Porsche",PORSCHES);
		COCHES.put("Dacia",DACIAS);
		
		COLORES.put("Rojo",1.07);
		COLORES.put("Negro",1.04);
		COLORES.put("Blanco",1.01);
		
		TIPOS.put(Tipo.NUEVO,1.3);
		TIPOS.put(Tipo.KM0,1.05);
		TIPOS.put(Tipo.USADO,0.95);
		
		EDADES.put(30.0,0.9);
		EDADES.put(25.0,0.95);
		EDADES.put(18.0,1.15);
		
		CARNETS.put(5.0,0.90);
		CARNETS.put(10.0,1.18);
		
	}
	
	@Override
	public Map<String, Double> getSeguro(String marca, String modelo, String color, Tipo tipo, LocalDate nacimiento, LocalDate carnet ) {
		Map<String,Double> precioSeguro = new HashMap<>();
		LocalDate hoy = LocalDate.now();
		
		
		try {
			Double factorCoche = COCHES.get(marca).get(modelo);
			Double factorColor = COLORES.get(color);
			Double factorTipo = TIPOS.get(tipo);
			Double factorNacimiento = null;
			Double factorCarnet = null;
			
			long edad = hoy.getYear() - nacimiento.getYear();
			long edadCarnet = hoy.getYear() - carnet.getYear();
			
			if (edad >= 30 && edad < 100) {
				factorNacimiento = EDADES.get(30.0);
			}
			else if (edad >= 25 && edad < 30) {
				factorNacimiento = EDADES.get(25.0);
			}
			else if (edad >= 18 && edad < 25) {
				factorNacimiento = EDADES.get(18.0);
			}
			else {
				throw new IllegalArgumentException("No puedes conducir");  
				}
			

			if (edadCarnet >= 10) {
				factorCarnet = CARNETS.get(10.0);
			}
			else if (edadCarnet < 10 && edadCarnet >= 0) {
				factorCarnet = CARNETS.get(5.0);
			}
			else {
				throw new IllegalArgumentException("No puedes conducir");  
			}
			
			precioSeguro.put("precio", seguroBase * factorCoche * factorColor * factorTipo * factorNacimiento * factorCarnet);
			
		} catch (Exception e) {
			if (!COCHES.keySet().contains(marca)) {
				throw new RuntimeException("La marca de coche no existe en la base de datos");
			}
			
			if (!COCHES.get(marca).keySet().contains(modelo)) {
				throw new RuntimeException("La modelo de coche no existe para esta marca");
			}
			if (!TIPOS.keySet().contains(tipo) ) {
				throw new RuntimeException("El tipo no es correcto");
			}
			
			if (!TIPOS.keySet().contains(tipo) ) {
				throw new RuntimeException("El tipo no es correcto");
			}
			if (hoy.getYear() - nacimiento.getYear() < 18) {
				throw new RuntimeException("Eres demasiado joven para conducir");
			}
			if (hoy.getYear() - carnet.getYear() < 0) {
				throw new RuntimeException("Aun no te has sacado el carnet");
			}
			throw new RuntimeException("Error no esperado");
		}
		
		return precioSeguro;
	}
/*
	@Override
	public Map<String, Map<String, Double>> createCoche(Map<String, Map<String, Double>> coche) {
		String codigo = coche.keySet().toString();
		Map<String,Double> infoCoche = coche.get(codigo);
		return null;
	}*/

}
