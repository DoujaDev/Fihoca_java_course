package com.fomentoformacion.gestionproductos.services;

import java.util.List;

import com.fomentoformacion.gestionproductos.model.Cancion;
import com.fomentoformacion.gestionproductos.model.Estilo;

public interface CancionServices {

	public Cancion create(Cancion cancion);
	public Cancion read(int codigo);
	
	public List<Cancion> getAll();
	
	public List<Cancion> getByEstilo(Estilo estilo);
	
}
