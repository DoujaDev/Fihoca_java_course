package com.esesola.cajondesastre.practicaRandomGroups;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupsGeneratorImplD implements GroupsGenerator {

	
	@Override
	public Map<String, List<String>> generate(int groupSize, String groupName, String... members) {
		// TODO Auto-generated method stub
		
		Map <String, List<String>> grupos = new HashMap<>();
		
		for(int i = 0; i< members.length; i++){
			
			int numeroGrupos = (members.length/groupSize)+1;
			
			List<String> grupo = new ArrayList<String>();
			int contador =0;
		
				if(grupo.size()< groupSize) {
					while (contador!= groupSize) {
						grupo.add(members[contador]);
						contador ++;
						grupos.put("grupo " + i, grupo);
					}
				}
				if (grupos.size() == numeroGrupos) {
					
					
					break;
				}
				
		return grupos;	
	}

	}
}


