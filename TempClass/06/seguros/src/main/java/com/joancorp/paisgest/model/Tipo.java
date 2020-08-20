package com.joancorp.paisgest.model;

public enum Tipo {
	NUEVO(0),
	KM0(-0.1),
	SEGUNDA_MANO(0.1);
	
	private double coeficiente;

	private Tipo(double coeficiente) {
		this.coeficiente = coeficiente;
	}

	public double getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(double coeficiente) {
		this.coeficiente = coeficiente;
	}

}
