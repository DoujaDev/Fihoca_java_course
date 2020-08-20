package com.DevSoft.helloworld.backend.services.controllers;


import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupsController {

	public Map<String, List<String> > getGroups(@RequestParam("size") int groupSize,
												@RequestParam("name") String groupName,
												@RequestParam("membres")  List<String> members
												){
		return null;
	}

}
