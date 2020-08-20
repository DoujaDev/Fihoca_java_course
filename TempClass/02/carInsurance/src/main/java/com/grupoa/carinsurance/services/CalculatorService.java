package com.grupoa.carinsurance.services;

import java.util.Date;

import com.grupoa.carinsurance.model.Car;

public interface CalculatorService {
	
	public double getPrice(String marca, String modelo, String color,
			String tipo, Date fechaNacimiento, Date fechaCarnet);
	
	public void addCar(Car car);

}
