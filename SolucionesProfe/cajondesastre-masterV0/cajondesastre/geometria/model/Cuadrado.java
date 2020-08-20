package com.pgrsoft.fihoca2019.cajondesastre.geometria.model;

public class Cuadrado extends Poligono {

	public Cuadrado(Punto v1, Punto v3) {
		super(v1,null,v3,null);
		
		this.vertices[1] = null; // TODO calcular
		this.vertices[3] = null; // TODO calcular
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

}
