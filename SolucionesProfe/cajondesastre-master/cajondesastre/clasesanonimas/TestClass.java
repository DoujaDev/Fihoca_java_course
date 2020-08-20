package com.pgrsoft.fihoca2019.cajondesastre.clasesanonimas;

public class TestClass {

	public static void main(String[] args) {
	
		Ejecutable ejecutable = new Ejecutable() {

			@Override
			public void run() {
				System.out.println("clase anónima!!!!");				
			}
		};
		
		ejecutable.run();
		
	}

}
