package com.pgrsoft.fihoca2019.cajondesastre.lifecycle;

import java.util.HashMap;
import java.util.Map;

public class Foo {
	
	private static int v1 = 100;
	private static Map<Integer,String> mapa = new HashMap<>();
	
	static {
		System.out.println("dentro del bloque de inicializaión estático");
		mapa.put(100,"cien");
	}
	
	{
		System.out.println("bloque pululante1");
	}
	
	public Foo() {
		System.out.println("constructor de Foo. v1 es: " + v1);
	}
	
	static {
		System.out.println("bloque estático2...");
	}

}
