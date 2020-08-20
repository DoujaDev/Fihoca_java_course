package com.fomentoformacion.gestionproductos.model;

import java.util.Date;

public class Producto {

	private int codigo;
	private String nombre;
	private double precio;
	private Familia familia;
	private Date fechaAlta;
	private boolean descatalogado;
	
	public Producto() {
		
	}

	public Producto(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public Producto(int codigo, String nombre, double precio, Familia familia, Date fechaAlta) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.familia = familia;
		this.fechaAlta = fechaAlta;
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

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public boolean isDescatalogado() {
		return descatalogado;
	}

	public void setDescatalogado(boolean descatalogado) {
		this.descatalogado = descatalogado;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", familia=" + familia
				+ ", fechaAlta=" + fechaAlta + ", descatalogado=" + descatalogado + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + (descatalogado ? 1231 : 1237);
		result = prime * result + ((familia == null) ? 0 : familia.hashCode());
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (descatalogado != other.descatalogado)
			return false;
		if (familia != other.familia)
			return false;
		if (fechaAlta == null) {
			if (other.fechaAlta != null)
				return false;
		} else if (!fechaAlta.equals(other.fechaAlta))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
			return false;
		return true;
	}
	

}
