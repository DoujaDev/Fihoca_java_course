package com.grupoa.carinsurance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoa.carinsurance.services.CalculatorService;

@RestController
public class CalculatorServiceController {
	
	@Autowired
	CalculatorService calculatorService;
	
	@GetMapping ("/precio")
	public double getPrice() {
		calculatorService.getPrice(marca, modelo, color, tipo, fechaNacimiento, fechaCarnet)
	}
	

}
