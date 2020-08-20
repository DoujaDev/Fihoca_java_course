package com.pgrsoft.demojpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EQUIPOS")
public class Equipo {
	
	@Id
	@Column(name="ID")
	private  Long id ;
	@Column(name="NOMBRE")
	private  String nombre;
	//@Column(name="MOTE")
	private String mote;
	@Column(name="ANYOFUNDACION")
	private int anyoFundacion;
	
	   public Equipo()
	   {
		   
	   }
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMote() {
		return mote;
	}
	public void setMote(String mote) {
		this.mote = mote;
	}
	public int getAnyoFundacion() {
		return anyoFundacion;
	}
	public void setAnyoFundacion(int anyoFundacion) {
		this.anyoFundacion = anyoFundacion;
	}
	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", mote=" + mote + ", anyoFundacion=" + anyoFundacion + "]";
	}
	
}
