package com.pgrsoft.fihoca2019.cajondesastre.herencia1;

public class TestClass {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		
		Taxista taxista = new Taxista();
	//	Persona persona = new Persona();
		
		Persona p1 = new Cliente();
		Persona p2 = new Taxista();
		
		Persona[] personas = {cliente,taxista,p1,p2};
		
		System.out.println(personas[0]);
		System.out.println(personas[1]);
		
		personas[0].setNombre("Lucas");
		
		
	}

}
