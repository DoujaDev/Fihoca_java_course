package com.joancorp.paisgest.model;

public enum Color {
	ROJO(0.4),
	BLANC(-0.1),
	NEGRO(0.1);
	
	private double coeficiente;

	private Color(double coeficiente) {
		this.coeficiente = coeficiente;
	}

	public double getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(double coeficiente) {
		this.coeficiente = coeficiente;
	}
	
}
