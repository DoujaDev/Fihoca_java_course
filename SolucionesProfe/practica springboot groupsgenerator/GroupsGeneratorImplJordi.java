package com.pgrsoft.demo.groupsgenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service(value="J")
public class GroupsGeneratorImplJordi implements GroupsGenerator {

	@Override
	public Map<String, List<String>> generate(int groupSize, String groupName, String... members) {
		
		List<LinkedList<String>> aux = crearGrupos(groupSize, Arrays.asList(members));
		return crearMapa(groupName, aux);
	}
	
	// *******************************************************************************
	//								METODOS PRIVADOS
	// *******************************************************************************
	
	// Montamos los grupos
	
	private List<LinkedList<String>> crearGrupos(int groupSize, List<String> members) {

		Collections.shuffle(members);
		
		List<LinkedList<String>> aux = new ArrayList<>();
		
		LinkedList<String> group = new LinkedList<>();

		for (String member : members) {		 			// iteramos todos los miembros

			group.add(member);							// añadimos miembro al grupo	

			if (group.size() == groupSize) {  			// si se completa un grupo...
				aux.add(group);				  			// añadimos grupo en la estructura	
				group = new LinkedList<>();	  			// creamos un nuevo grupo
			}
		}

		// distribución de miembros sobrantes...

		int contador = 0;

		while (group.size() != 0) {						// mientras haya un grupo con miembros sobrantes
			aux.get(contador++).add(group.pop());		// sacamos miembro del grupo y lo redistribuimos
		}

		return aux;
	}
	
	
	// Montamos el mapa
	
	private Map<String, List<String>> crearMapa(String groupName, List<LinkedList<String>> aux) {
			
		Map<String, List<String>> mapa = new HashMap<>(); 	// pasamos de aux al mapa...
			
		int groupNumber = 0; 
			
		for(List<String> grupo: aux) {
			mapa.put(groupName + groupNumber++, grupo);
		}
			
		return mapa;
	}

}
