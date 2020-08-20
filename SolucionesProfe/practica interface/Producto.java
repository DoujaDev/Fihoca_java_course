package com.pgrsoft.fihoca2019.cajondesastre.practicacollections;

import java.io.Serializable;
import java.util.Date;

public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nombre;
	private Date fechaAlta;
	private double precio;
	private Familia familia;
	private boolean descatalogado;
	
	public Producto() {
		
	}

	public Producto(int codigo, String nombre, double precio, Familia familia) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.familia = familia;
	}

	public Producto(int codigo, String nombre, Date fechaAlta, double precio, Familia familia) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		this.precio = precio;
		this.familia = familia;
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

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public boolean isDescatalogado() {
		return descatalogado;
	}

	public void setDescatalogado(boolean descatalogado) {
		this.descatalogado = descatalogado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", fechaAlta=" + fechaAlta + ", precio=" + precio
				+ ", familia=" + familia + ", descatalogado=" + descatalogado + "]";
	}
	
}
