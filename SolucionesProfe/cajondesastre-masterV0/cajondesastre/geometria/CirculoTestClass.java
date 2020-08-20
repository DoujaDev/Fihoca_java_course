package com.pgrsoft.fihoca2019.cajondesastre.geometria;

import com.pgrsoft.fihoca2019.cajondesastre.geometria.model.Circulo;
import com.pgrsoft.fihoca2019.cajondesastre.geometria.model.Punto;

public class CirculoTestClass {

	public static void main(String[] args) {
		
		Circulo c1 = new Circulo(0.0,0.0,10.0);
		Circulo c2 = new Circulo(new Punto(10.0,10.0), 100.0);
		
		System.out.println(c1);
		System.out.println(c2);
		
		c1.trasladar(100.0, -50.0);
		
		System.out.println(c1);
		
		System.out.println("area c1: " + c1.getArea());
		System.out.println("perímetro c1: " + c1.getPerimetro());

	}

}
