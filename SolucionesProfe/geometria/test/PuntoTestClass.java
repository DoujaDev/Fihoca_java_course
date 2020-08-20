package com.pgrsoft.fihoca2019.cajondesastre.geometria;

import com.pgrsoft.fihoca2019.cajondesastre.geometria.model.Punto;

public class PuntoTestClass {

	public static void main(String[] args) {
		
		Punto p1 = new Punto(0.0,0.0);
		Punto p2 = new Punto(0.0,10.0);
		
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println("distancia: " + p1.distancia(p2));
		
		p1.trasladar(5.0, -20.0);
		p2.trasladar(-20, 40);
		
		System.out.println(p1);
		System.out.println(p2);

	}

}
