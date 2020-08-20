package com.pgrsoft.helloworld.backend.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupsController {

	// Forma de realizar la petición desde Chrome:
	
	// localhost:8080/groups?size=3&name=GRUPO&members=01,02,03,04,05,06,07,08,09,10,11,12,13
	
	@GetMapping("/groups")
	public Map<String,List<String>> getGroups(@RequestParam("size") int groupSize,
											  @RequestParam("name") String groupName,
											  @RequestParam("members") List<String> members){
		
		System.out.println("groupSize: " + groupSize);
		System.out.println("groupName: " + groupName);
		System.out.println("members: " + members);
		
		// TODO     Esto no ha de devolver null!!!!! Tenéis que incorporar el código de ayer!
		
		return null;
	}
	
}
