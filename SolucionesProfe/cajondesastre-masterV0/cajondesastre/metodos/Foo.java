package com.pgrsoft.fihoca2019.cajondesastre.metodos;

public class Foo {
	
	// los nombres de los m�todos deben ser came case y empezar en min�scula
	// los nombres de los m�todos deben ser verbos
	
	public String getSaludo() {
		return "Hola!"; // one-liners
	}
	
	public void imprime(String texto) {
		System.out.println("mensaje: " + texto);
	}
	
	public void doSomething() {
		System.out.println(suma(10,20));
	}
	
	// synchronized: impide que diferentes hilos entren en �l de forma concurrente
	// final: no se puede hacer override de este m�todo...
	
	private synchronized final int suma(int a, int b) {
		return a + b;
	}


	
}
