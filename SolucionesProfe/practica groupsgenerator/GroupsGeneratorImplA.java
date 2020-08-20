package com.fatimasoft.cajondesastre.practicagroupgenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class GroupsGeneratorImplA implements GroupsGenerator {

	@Override
	public Map<String, List<String>> generate(int groupSize, String groupName, String... members) {
		
		LinkedList <String> miembros = new LinkedList <>(Arrays.asList(members));
		// creamos un mapa
		Map<String, List<String>> grupos = new TreeMap<String, List <String>>();
		
		//MEZCLAR MIEMBROS
		
		Collections.shuffle(miembros);
	
		int contador = 0;
		for (int i=groupSize; i<=members.length; i= i+groupSize) {
			contador+=1;
			String nombreGrupo = groupName + contador;
			List <String> miembrosGrupo = miembros.subList(i-groupSize, i);
			grupos.put(nombreGrupo, miembrosGrupo);
		}
		
		int reminders = members.length % groupSize;
		
		LinkedList <String> sobrantes = new LinkedList <> (miembros.subList(miembros.size() - reminders, miembros.size()));
		List <String> keys = new ArrayList <String> (grupos.keySet() );
		
		for (String s : keys) {
			
			if(sobrantes.size()<1) {
				break;
			}
			
			grupos.get(s).add(sobrantes.pop());
//			System.out.println(grupos);
		}
	
			
			
		//	grupos.get(randomKey).add(miembros.get(members.length - reminders + i));
			
		

		
		return grupos;
	}

}