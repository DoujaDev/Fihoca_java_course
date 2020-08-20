package com.alfresoft.cajondesastre.practicarandomgroups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupsGeneratorImplB implements GroupsGenerator {

	@Override
	public Map<String, List<String>> generate(int groupSize, String groupName, String... members) {
		
		if(groupSize == 0 ) {
			throw new IllegalArgumentException("El número de grupos debe ser mayor que cero ");
		}
		
		if(members == null || members.length == 0) {
			throw new IllegalArgumentException("El número de miembros debe ser mayor que cero ");
		}
		
		if(groupName == null) {
			throw new IllegalArgumentException("El número de miembros debe ser mayor que cero ");
		}
		
		if(groupSize > members.length) {
			throw new IllegalArgumentException("El número de miembros debe ser mayor que cero ");
		}
		
		
		else {
			
			List<String> aux = Arrays.asList(members);
			Collections.shuffle(aux);
			aux.toArray(members);
			
			Map<String, List<String>> resultado = new HashMap <>(); 
			int numeroGrupos = (int)members.length/groupSize;
			int numeroSobrantes = members.length%groupSize;
			List<String> miembrosGrupos;
			
			int cont = 0;
			
			for(int i = 0; i < numeroGrupos; i++) {
				
				miembrosGrupos= new ArrayList<String>();
				
					for(int j = 0; j < groupSize; j++) {
						if(members[cont] == null) {
							throw new IllegalArgumentException("Null en miembros ");
						}
						miembrosGrupos.add(members[cont]);
						cont++;
					}
				
				resultado.put(groupName + (i + 1), miembrosGrupos);
			}
			
			if(numeroSobrantes > 0) {
			
				int g=0;
				
				for(int i =0; i < numeroSobrantes; i++) {
					
					(resultado.get(groupName+(g + 1))).add(members[cont]);
					cont++;
					g++;
					
					if(i > numeroGrupos) {
						g = 0;
					}
				}
			}
			
			return resultado;
	
		}
			
	}
	
}