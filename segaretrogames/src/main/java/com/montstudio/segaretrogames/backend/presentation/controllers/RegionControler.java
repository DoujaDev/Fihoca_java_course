package com.montstudio.segaretrogames.backend.presentation.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.montstudio.segaretrogames.backend.integration.model.Region;

@RestController
public class RegionControler {

	@RequestMapping(value="/regions",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> getSystems(){

		List<String> regions = new ArrayList<String>();


		for(Region region : Region.values()) {
			regions.add(region.toString());
		}

		return regions;
}
	
	
}
