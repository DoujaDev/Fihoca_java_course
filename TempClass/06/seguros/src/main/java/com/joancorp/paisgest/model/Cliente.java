package com.joancorp.paisgest.model;

import java.time.LocalDate;

public class Cliente {

	private LocalDate fechaNacimiento;
	private LocalDate fechaCarnet;
	
	public Cliente() {
		
	}
	
	public Cliente(LocalDate fechaNacimiento, LocalDate fechaCarnet) {
		super();
		this.fechaNacimiento = fechaNacimiento;
		this.fechaCarnet = fechaCarnet;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaCarnet() {
		return fechaCarnet;
	}

	public void setFechaCarnet(LocalDate fechaCarnet) {
		this.fechaCarnet = fechaCarnet;
	}

	@Override
	public String toString() {
		return "Cliente [fechaNacimiento=" + fechaNacimiento + ", fechaCarnet=" + fechaCarnet + "]";
	}
	
}
