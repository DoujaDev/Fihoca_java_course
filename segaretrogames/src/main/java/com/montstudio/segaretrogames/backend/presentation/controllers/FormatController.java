package com.montstudio.segaretrogames.backend.presentation.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.montstudio.segaretrogames.backend.integration.model.MediaFormat;

@RestController
public class FormatController {

	@RequestMapping(value="/formats",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> getFormats(){

		List<String> formats = new ArrayList<String>();

		for(MediaFormat format : MediaFormat.values()) {
			formats.add(format.toString());
		}

		return formats;
	}
	
}
