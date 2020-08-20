package com.pgrsoft.fihoca2019.cajondesastre.collections1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class TestClass {

	public static void main(String[] args) {
		
		separador("Map");
		testMap();
		separador("List");
		testList();
		separador("Set");		
		testSet();
		
	}
	
	private static void testMap() {
		
		Map<Integer,String> mapa = new HashMap<>();
		
		// Añadimos elementos en el mapa...
		
		mapa.put(9,"nueve");
		mapa.put(11,"once");
		mapa.put(3,"tres");
		mapa.put(7,"siete");
		
		// Tamaño del mapa
		
		System.out.println("tamaño del mapa: " + mapa.size()); // realmente me da el número de keys
		
		// Obtener un elemento del mapa
		
		System.out.println("elemento 3: " + mapa.get(3));
		
		// Iteramos el mapa utilizando el "conjunto de las llaves"
		
		Set<Integer> keys = mapa.keySet();
		
		for(Integer key: keys) {
			System.out.println(key + ": " + mapa.get(key));
		}
		
		// Iteramos el mapa "pasando de las llaves"
		
		Collection<String> values = mapa.values();
		
		for(String value: values) {
			System.out.println(value);
		}
		
		
		
		
		
	}
	
	private static void testSet() {
		
		String str1 = "A";
		String str2 = "B";
		String str3 = "C";
		String str4 = "E";
		String str5 = "E";
		
		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new LinkedHashSet<>();
		Set<String> set3 = new TreeSet<>();
		
		set1.add(str3);
		set1.add(str1);
		set1.add(str2);
		set1.add(str5);
		set1.add(str4);
		
		set2.add(str3);
		set2.add(str1);
		set2.add(str2);
		set2.add(str5);
		set2.add(str4);
		
		set3.add(str3);
		set3.add(str1);
		set3.add(str2);
		set3.add(str5);
		set3.add(str4);
		
		System.out.println("Tamaño de set1: " + set1.size());
		System.out.println("HashSet NO NOS GARANTIZA ORDEN (aunque lo parezca): " + set1);
		System.out.println("LinkedHashSet nos garantiza el orden de llegada: " + set2);
		System.out.println("TreeSet nos garantiza el orden: "  + set3);
		
	}
	
	private static void testList() {
		
		List<String> nombres = new ArrayList<>();
		
		nombres.add("Pepe");
		nombres.add("Juan");
		nombres.add("Carlota");
		
		System.out.println("tamaño de la lista: " + nombres.size());
		
		System.out.println(nombres.get(1));
		
		nombres.remove(0);
		System.out.println("tamaño de la lista: " + nombres.size());
		System.out.println(nombres.get(0));
		
		// forma "clásica" de iterar
		
		for(int i = 0; i < nombres.size(); ++i) {
			System.out.println(i + ": " + nombres.get(i));
		}
		
		// iteramos utilizando "for each"
		for(String nombre: nombres) {
			System.out.println(nombre);
		}
		
		// Iteramos con un iterador
		
		Iterator<String> iterador = nombres.iterator();
		
		while(iterador.hasNext()) {
			String nombre = iterador.next();
			System.out.println("---> " + nombre);
		}
		
		// iterar utilizando Streams de Java 8
		
		nombres.stream().forEach(x -> {
			System.out.println("===> " + x);
		});
		
		System.out.println(nombres);
		
		nombres.clear();
		System.out.println("tamaño de la lista: " + nombres.size());
		
		
	}
	
	private static void separador(String cabecera) {
		System.out.println("\n***********************************");
		System.out.println(cabecera);
		System.out.println("***********************************");
	}

}
