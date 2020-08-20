package com.fomentoformacion.gestionproductos.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fomentoformacion.gestionproductos.model.Cancion;
import com.fomentoformacion.gestionproductos.model.Estilo;
import com.fomentoformacion.gestionproductos.services.CancionServices;

public class CancionServicesImpl implements CancionServices{

	private static final Map<Integer,Cancion> CANCIONES = new HashMap<>();
	
	// inicializo la "DB" con algunas canciones de ejemplo
	
	static {
	
	Cancion c1 = new Cancion(100, "Subeme la Radio", Estilo.REGGEATON);
	c1.setAnyo(2017);
	c1.setArtista("Enrique Iglesias");
	c1.addComentario("Obra maestra");
	c1.addComentario("Buenísima...");
	
	Cancion c2 = new Cancion(110, "La la la", Estilo.HEAVY);
	c2.setAnyo(1968);
	c2.setArtista("Masiel");
	c2.addComentario("Solo le gusta a Jordi....");
	
	Cancion c3 = new Cancion(120, "Atomic Dog", Estilo.FUNK);
	c3.setArtista("parliament");
	c3.setAnyo(1979);
	c3.addComentario("Solo le gusta a Jordi");
	c3.addComentario("Muy pesada....");
	c3.setExplicito(true);
	
	CANCIONES.put(c1.getCodigo(),c1);
	CANCIONES.put(c2.getCodigo(),c2);
	CANCIONES.put(c3.getCodigo(),c3);
	
	}
	
	@Override
	public Cancion create(Cancion cancion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cancion read(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cancion> getAll() {
		return new ArrayList<Cancion>(CANCIONES.values());
	}

	@Override
	public List<Cancion> getByEstilo(Estilo estilo) {
		// TODO Auto-generated method stub
		return null;
	}

}
