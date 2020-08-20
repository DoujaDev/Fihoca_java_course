package com.joancorp.paisgest.model;

import java.util.HashMap;

//
import java.util.Map;

public class Vehiculo {
	
	public static Map<Vehiculo, Double> preciosBase = new HashMap<>();
	public static Map<String[], Integer> codigos = new HashMap<>();
	
	static {
		
		Vehiculo vehiculo1 = new Vehiculo("Seat", "Leon");
		Vehiculo vehiculo3 = new Vehiculo("Seat", "Ibiza");
		Vehiculo vehiculo2 = new Vehiculo("Renault", "Clio");
		Vehiculo vehiculo4 = new Vehiculo("Renault", "Laguna");
		
		preciosBase.put(vehiculo1, 200.3);
		preciosBase.put(vehiculo2, 150.0);
		preciosBase.put(vehiculo3, 100.0);
		preciosBase.put(vehiculo4, 5000.0);
		
		String[] v1 = {"Seat", "Leon"};
		String[] v2 = {"Seat", "Ibiza"};
		String[] v3 = {"Renault", "Clio"};
		String[] v4 = {"Renault", "Laguna"};
		
		codigos.put(v1, 1);
		codigos.put(v2, 2);
		codigos.put(v3, 3);
		codigos.put(v4, 4);
		
	}
	
	private Integer codigo;
	private String marca;
	private String modelo;
	
	public Vehiculo() {
		
	}

	public Vehiculo(String marca, String modelo) {
		super();
		
		this.marca = marca;
		this.modelo = modelo;
		
		String[] marcaModel = {marca, modelo};
		
		this.codigo = codigos.get(marcaModel);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public static Map<Vehiculo, Double> getPreciosbase() {
		return preciosBase;
	}

	@Override
	public String toString() {
		return "Vehiculo [codigo=" + codigo + ", marca=" + marca + ", modelo=" + modelo + "]";
	}
	
}
