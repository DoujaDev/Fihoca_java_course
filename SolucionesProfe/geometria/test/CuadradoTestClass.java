package com.pgrsoft.fihoca2019.cajondesastre.geometria;

import com.pgrsoft.fihoca2019.cajondesastre.geometria.model.Cuadrado;
import com.pgrsoft.fihoca2019.cajondesastre.geometria.model.Punto;

public class CuadradoTestClass {

	public static void main(String[] args) {
		
		Cuadrado c1 = new Cuadrado(new Punto(0.0,0.0), new Punto(10.0,10.0));
		
		System.out.println(c1);
		c1.trasladar(-100.0, -100.0);
		System.out.println(c1);

		System.out.println("area cuadrado: " + c1.getArea());
		System.out.println("perímetro cuadrado: " + c1.getPerimetro());

		
	}

}
