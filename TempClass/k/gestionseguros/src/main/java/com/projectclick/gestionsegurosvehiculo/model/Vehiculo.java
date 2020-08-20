package com.projectclick.gestionsegurosvehiculo.model;

import java.util.Date;

public class Vehiculo {

	private Integer codigo;
	private String marca;
	private String modelo;
	private String color;
	private Tipo tipo;
	private Date fechaNacimiento;
	private Date fechaCarnet;
	
	public Vehiculo () {
		
	}

	
	public Vehiculo(Integer codigo, String marca, String modelo, String color, Tipo tipo, Date fechaNacimiento,
			Date fechaCarnet) {
		super();
		this.codigo = codigo;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.tipo = tipo;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaCarnet = fechaCarnet;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaCarnet() {
		return fechaCarnet;
	}

	public void setFechaCarnet(Date fechaCarnet) {
		this.fechaCarnet = fechaCarnet;
	}


	@Override
	public String toString() {
		return "Vehiculo [codigo=" + codigo + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", tipo="
				+ tipo + ", fechaNacimiento=" + fechaNacimiento + ", fechaCarnet=" + fechaCarnet + "]";
	}


	
}
