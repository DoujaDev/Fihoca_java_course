package com.joancorp.paisgest.model;



public class Vehiculo {
	
	/*
	public static Map<String[], Integer> codigos = new HashMap<>();
	
	static {
		
		String[] v1 = {"Seat", "Leon"};
		String[] v2 = {"Seat", "Ibiza"};
		String[] v3 = {"Renault", "Clio"};
		String[] v4 = {"Renault", "Laguna"};
		
		codigos.put(v1, 1);
		codigos.put(v2, 2);
		codigos.put(v3, 3);
		codigos.put(v4, 4);
		
	}
	*/
	private Integer codigo;
	private String marca;
	private String modelo;
	
	public Vehiculo() {
		
	}
	
	public Vehiculo(Integer codigo, String marca, String modelo) {
		super();
		this.codigo = codigo;
		this.marca = marca;
		this.modelo = modelo;
	}

	/*
	public Vehiculo(String marca, String modelo) {
		super();
		
		this.marca = marca;
		this.modelo = modelo;
		
		String[] marcaModel = {marca, modelo};
		
		System.out.println(marcaModel);
		System.out.println(codigos.get(marcaModel));
		
		this.codigo = codigos.get(marcaModel);

	}*/

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

	@Override
	public String toString() {
		return "Vehiculo [codigo=" + codigo + ", marca=" + marca + ", modelo=" + modelo + "]";
	}
	
}
