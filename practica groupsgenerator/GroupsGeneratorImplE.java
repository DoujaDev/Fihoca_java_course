package com.projectclick.cajondesastre.generatorrandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class GroupsGeneratorImplE implements GroupsGenerator {

	@Override
	public Map<String, List<String>> generate(int groupSize, String groupName, String... members) {
		Map<String,List<String>> mapaGrupo = new HashMap<>();
		
		double grup = members.length/groupSize;
		int grupos = (int)grup;
		
		List<String> keys = new ArrayList<>();
		String key = new String();
		
		for(int i = 1; i < grupos+1; i++) {
			
			key = groupName + "" + i; 
			keys.add(key);
			
		}
		List <String> listMembers = Arrays.asList(members);
		Collections.shuffle(listMembers);
		System.out.println(listMembers);
		for(int i = 0 ; i < keys.size(); i++) {
		 
			List<String> values = new ArrayList<>();
			
			for(int j = i; j < groupSize+i; j++) {
				
					values.add(listMembers.get(j));
				}
			
			mapaGrupo.put(keys.get(i), values);
			
		}
		System.out.println(mapaGrupo);
		
				
		return mapaGrupo;
	}
	
		//System.out.println("tamaño de mapa: " + mapaGrupo.size());
}	
	//nuevo cogigo
/*
 * package com.projectclick.cajondesastre.generatorrandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class GroupsGeneratorImpl implements GroupsGenerator {

	@Override
	public Map<String, List<String>> generate(int groupSize, String groupName, String... members) {
		
		Map<String,List<String>> mapaGrupo = new HashMap<>();
	
		LinkedList<String> listMembers = new LinkedList<>(Arrays.asList(members));
		
		Collections.shuffle(listMembers);
		
		System.out.println(listMembers);
		
		double grup = members.length/groupSize;
		int grupos = (int)grup; 
		
		int n = members.length;
		
		
		while(n !=0){
			
		
			String key = new String();
			
			for(int i = 1; i < grupos+1; i++) {
				
				key = groupName + "" + i;
				String k = listMembers.pop();
			
			n--;
			
			}
		
		}
		
		List<String> keys = new ArrayList<>();
		String key = new String();
		
		for(int i = 1; i < grupos+1; i++) {
			
			key = groupName + "" + i; 
			keys.add(key);
			
		}
		
		
		int n = 1;
		
		for(int i = 0 ; i < keys.size(); i++) {
		 
			List<String> values = new ArrayList<>();
			
			
			while(n % groupSize != 0 ) {
			
					values.add(listMembers.get(n-1));
					n++;
					
				}
			
			mapaGrupo.put(keys.get(i), values);
		
		}
		System.out.println(mapaGrupo);
		
				
		return mapaGrupo;
	}
	
		//System.out.println("tamaño de mapa: " + mapaGrupo.size());
}
 * */


