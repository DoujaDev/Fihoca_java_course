package com.pgrsoft.fihoca2019.cajondesastre.model1;

public class TestClass {

	public static void main(String[] args) {
		
		Coche c1 = new Coche();
		
		@SuppressWarnings("unused")	// No quiero ni un solo warning en mi proyecto!
		Coche c2 = new Coche();
		
		new Coche();            	// creamos un objeto inutil...
		
		c1.automatico = true;		// Accedemos directamente a las variables de instancia
		c1.codigo = 1023;
		c1.marca = "SEAT";
		c1.modelo = "IBIZA";
		
		
		
		

	}

}
