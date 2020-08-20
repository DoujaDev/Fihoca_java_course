package com.pgrsoft.fihoca2019.cajondesastre.geometria.model;

import java.util.Arrays;

public abstract class Poligono implements Figura{

	protected Punto[] vertices;
	
	// veriargs
	public Poligono(Punto ...vertices) {
		// TODO compr obar que número de vertices sea >= 3
		this.vertices = vertices;
	}
	
	@Override
	public void trasladar(double deltaX, double deltaY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getPerimetro() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Punto[] getVertices() {
		return vertices;
	}

	@Override
	public String toString() {
		return "Poligono [vertices=" + Arrays.toString(vertices) + "]";
	}
	
}
