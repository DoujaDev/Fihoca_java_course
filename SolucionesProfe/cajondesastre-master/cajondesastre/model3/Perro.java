package com.pgrsoft.fihoca2019.cajondesastre.model3;

import java.io.Serializable;
import java.util.Date;

public class Perro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nombre;
	private Date fechaNacimiento;
	private boolean peligroso;

	public Perro() {
		
	}
	
	public Perro(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public boolean isPeligroso() {
		return peligroso;
	}
	
	public void setPeligroso(boolean peligroso) {
		this.peligroso = peligroso;
	}

	@Override
	public String toString() {
		return "Perro [codigo=" + codigo + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
				+ ", peligroso=" + peligroso + "]";
	}
}
