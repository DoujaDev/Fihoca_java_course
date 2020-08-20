package com.montstudio.segaretrogames.backend.presentation.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.montstudio.segaretrogames.backend.integration.model.Platform;

@RestController
public class PlatformController {

	@RequestMapping(value="/platforms",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> getSystems(){
		
		List<String> platforms = new ArrayList<String>();
		
	
		for(Platform platform : Platform.values()) {
			platforms.add(platform.toString());
		}
		
		return platforms;
	}
	
}
