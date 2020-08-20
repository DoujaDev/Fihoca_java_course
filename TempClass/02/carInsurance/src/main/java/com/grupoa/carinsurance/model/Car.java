package com.grupoa.carinsurance.model;

public class Car {
	
	private String marca;
	private String modelo;
	private double precio;
	
	public Car() {}

	public Car(String marca, String modelo, double precio) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Car [marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + "]";
	}
	
	
}
