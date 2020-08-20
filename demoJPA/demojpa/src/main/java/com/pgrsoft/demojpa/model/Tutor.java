package com.pgrsoft.demojpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TUTORES")
public class Tutor {
	
	@Id
	private Long id;
	
	private String nombre;
	private String mote;

	public Tutor() {
		
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

	@Override
	public String toString() {
		return "Tutor [id=" + id + ", nombre=" + nombre + ", mote=" + mote + "]";
	}
	
}

