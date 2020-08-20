package com.pgrsoft.carinsurance.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pgrsoft.carinsurance.model.Tipo;
import com.pgrsoft.carinsurance.model.Vehiculo;

@Service
public class SeguroServicesImpl implements SeguroServices{

	private static final Map<Integer,Vehiculo> VEHICULOS = new HashMap<>();
	private static final Map<Integer,Double> COEFICIENTES_VEHICULO = new HashMap<>();
	private static final Map<String,Double> COEFICIENTES_COLOR = new HashMap<>();
	private static final Map<Tipo,Double> COEFICIENTES_TIPO = new HashMap<>();
	private static final double PRECIO_BASE = 100.0;
	
	static {
		
		Vehiculo v01 = new Vehiculo(100,"Audi","A8");
		Vehiculo v02 = new Vehiculo(101,"Audi","A4");
		Vehiculo v03 = new Vehiculo(102,"Volkswagen","Touran");
		Vehiculo v04 = new Vehiculo(103,"SEAT","Arona");
		Vehiculo v05 = new Vehiculo(104,"Volkswagen","Golf");
		Vehiculo v06 = new Vehiculo(105,"Renault","Clio");
		Vehiculo v07 = new Vehiculo(106,"Volkswagen","Polo");
		Vehiculo v08 = new Vehiculo(107,"BMW","i3");
		Vehiculo v09 = new Vehiculo(108,"Skoda","Fabia");
		Vehiculo v10 = new Vehiculo(109,"Audi","A6");
		
		VEHICULOS.put(v01.getCodigo(),v01);
		VEHICULOS.put(v02.getCodigo(),v02);
		VEHICULOS.put(v03.getCodigo(),v03);
		VEHICULOS.put(v04.getCodigo(),v04);
		VEHICULOS.put(v05.getCodigo(),v05);
		VEHICULOS.put(v06.getCodigo(),v06);
		VEHICULOS.put(v07.getCodigo(),v07);
		VEHICULOS.put(v08.getCodigo(),v08);
		VEHICULOS.put(v09.getCodigo(),v09);
		VEHICULOS.put(v10.getCodigo(),v10);
		
		COEFICIENTES_VEHICULO.put(v01.getCodigo(),0.5);
		COEFICIENTES_VEHICULO.put(v02.getCodigo(),0.3);
		COEFICIENTES_VEHICULO.put(v03.getCodigo(),0.2);
		COEFICIENTES_VEHICULO.put(v04.getCodigo(),0.1);
		COEFICIENTES_VEHICULO.put(v05.getCodigo(),0.2);
		COEFICIENTES_VEHICULO.put(v06.getCodigo(),0.0);
		COEFICIENTES_VEHICULO.put(v07.getCodigo(),0.0);
		COEFICIENTES_VEHICULO.put(v08.getCodigo(),0.4);
		COEFICIENTES_VEHICULO.put(v09.getCodigo(),0.1);
		COEFICIENTES_VEHICULO.put(v10.getCodigo(),0.3);
		
		COEFICIENTES_COLOR.put("rojo", 0.2);
		COEFICIENTES_COLOR.put("negro", 0.2);
		COEFICIENTES_COLOR.put("blanco", -0.1);
		
		COEFICIENTES_TIPO.put(Tipo.KM0, 0.1);
		COEFICIENTES_TIPO.put(Tipo.NUEVO, 1.0);
		COEFICIENTES_TIPO.put(Tipo.SEGUNDA_MANO, 0.1);
		
	}
	
	@Override
	public double calculatePrice(int codigoVehiculo, String color, Tipo tipo, Date fechaNacimiento, Date fechaCarnet) {
	
		double precioVehiculo = PRECIO_BASE * COEFICIENTES_VEHICULO.get(codigoVehiculo);
		
		double precioColor = 0;
		
		if (COEFICIENTES_COLOR.containsKey(color)) {
			precioColor = PRECIO_BASE * COEFICIENTES_COLOR.get(color);
		}
		
		double precioTipo = PRECIO_BASE * COEFICIENTES_TIPO.get(tipo);
		
		return PRECIO_BASE + precioVehiculo + precioColor + precioTipo;
	}
	
	@Override
	public double calculatePrice(Vehiculo vehiculo, String color, Tipo tipo, Date fechaNacimiento, Date fechaCarnet) {
		return calculatePrice(vehiculo.getCodigo(),color,tipo,fechaNacimiento,fechaCarnet);
	}

	@Override
	public double calculatePrice(String marca, String modelo, String color, Tipo tipo, Date fechaNacimiento, Date fechaCarnet) {
		
		for(Vehiculo vehiculo: VEHICULOS.values()) {
			if (vehiculo.getMarca().equalsIgnoreCase(marca) && vehiculo.getModelo().equalsIgnoreCase(modelo)) {
				return calculatePrice(vehiculo.getCodigo(),color, tipo, fechaNacimiento, fechaCarnet);
			}
		}
		
		throw new RuntimeException("vehiculo no encontrado!");
		
	}
	
	@Override
	public List<String> getTipos() {
		
		List<String> tipos = new ArrayList<>();
		
		for(Tipo tipo: Tipo.values()) {
			tipos.add(tipo.toString());
		}
		
		return tipos;
	}

	@Override
	public List<Vehiculo> getVehiculos() {
		return new ArrayList<Vehiculo>(VEHICULOS.values());
	}

}
