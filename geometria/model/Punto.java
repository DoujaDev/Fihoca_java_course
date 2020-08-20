package com.pgrsoft.fihoca2019.cajondesastre.geometria.model;

public class Punto {
	
	private double x;
	private double y;
	
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public void trasladar(double deltaX, double deltaY) {
		x += deltaX;
		y += deltaY;
	}
	
	public double distancia(Punto otro) {
		// TODO
		return 0;
	}

	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}

}
