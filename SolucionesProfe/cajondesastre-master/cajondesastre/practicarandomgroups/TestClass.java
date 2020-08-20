package com.pgrsoft.fihoca2019.cajondesastre.practicarandomgroups;

import java.util.List;
import java.util.Map;

public class TestClass {

	public static void main(String[] args) {
		
		GroupsGenerator groupsGenerator = new GroupsGeneratorImpl();
		
	//	Map<String, List<String>> grupos = groupsGenerator.generate(2, "GRUPO", "m1","m2","m3","m4","m5");
	//	Map<String, List<String>> grupos = groupsGenerator.generate(2, "GRUPO", "m1","m2","m3","m4","m5");
		Map<String, List<String>> grupos = groupsGenerator.generate(2, "GRUPO", "m1","m2","m3","m4","m5");
	//	Map<String, List<String>> grupos = groupsGenerator.generate(2, "GRUPO", "m1","m2","m3","m4","m5");

		
		//TODO mostrar resultado por consola...
		
	}

}
