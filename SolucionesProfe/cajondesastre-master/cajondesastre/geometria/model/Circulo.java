package com.pgrsoft.fihoca2019.cajondesastre.geometria.model;

public class Circulo implements Figura {

	private Punto centro;
	private double radio;
	
	public Circulo(Punto centro, double radio) {
		this.centro = centro;
		this.radio = radio;
	}
	
	public Circulo(double x, double y, double radio) {
		this.centro = new Punto(x,y);
		this.radio = radio;
	}
	
	public Punto getCentro() {
		return centro;
	}

	public double getRadio() {
		return radio;
	}

	@Override
	public void trasladar(double deltaX, double deltaY) {
		this.centro.trasladar(deltaX, deltaY);
	}

	@Override
	public double getPerimetro() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Circulo [centro=" + centro + ", radio=" + radio + "]";
	}
	
}
