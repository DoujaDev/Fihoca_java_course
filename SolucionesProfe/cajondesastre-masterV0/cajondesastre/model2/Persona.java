package com.pgrsoft.fihoca2019.cajondesastre.model2;

public class Persona {
	
	private int codigo;
	private String nombre;
	private double altura;
	private double peso;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double altura) {
		
		if (altura < 0 || altura > 3.0) {
			throw new IllegalArgumentException("La altura " + altura  + " no es correcta.");
		}
		
		this.altura = altura;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
}
