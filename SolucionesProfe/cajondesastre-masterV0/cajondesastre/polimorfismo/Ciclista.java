package com.pgrsoft.fihoca2019.cajondesastre.polimorfismo;

public class Ciclista implements Deportista {

	@Override
	public void entrenar() {
		System.out.println("ciclista entrenando de forma específica");
	}

	@Override
	public void competir() {
		System.out.println("ciclista comptiendo a su manera");
		
	}
}
