package com.pgrsoft.demojpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.demojpa.model.Alumno;
import com.pgrsoft.demojpa.services.AlumnoServices;

@RestController
public class AlumnoController {

	@Autowired
	private AlumnoServices alumnoServices;
	
	@GetMapping("/alumnos")
	public List<Alumno> getAll(){
		return alumnoServices.findAll();
	}
	
}
