package com.pgrsoft.fihoca2019.cajondesastre.igualdad;

public class TestClass {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente(100,"Pepín","Gálvez","Ridruejo");
		Cliente c2 = new Cliente(101,"Bartolo","Gálvez","Ridruejo");
		
		// nos preguntamos si las referencias apuntan al mismo objeto
		if (c1 == c2) {
			System.out.println("son el mismo objeto");
		} else {
			System.out.println("no son el mismo objeto");
		}
		
		// nos preguntamos si son iguales
		if (c1.equals(c2)) {
			System.out.println("son iguales");
		} else {
			System.out.println("no son iguales");
		}
		

	}

}
