package com.pgrsoft.demojpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="JUGADORES")
public class Jugador {
	
	@Id
	@Column(name="ID")
	private  Long id ;
	@Column(name="NOMBRE")
	private  String nombre;
	
	private  String apellidos;
	
	@Column(name="MOTE")
	private String mote;
	private  String posicion;
	@Column(name="DORSAL")
	private int dorsal;
	
	@ManyToOne
	@JoinColumn(name = "ID_EQUIPO")
	private Equipo equipo;
	
	public Jugador()
	{
	
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", mote=" + mote
				+ ", posicion=" + posicion + ", dorsal=" + dorsal + ", equipo=" + equipo + "]";
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getMote() {
		return mote;
	}

	public void setMote(String mote) {
		this.mote = mote;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	

}
