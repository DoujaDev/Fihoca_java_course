package com.empresaa.paises.services;

import java.util.List;

import com.empresaa.paises.model.Pais;

@SpringBootAplication
public interface PaisesServices {

	public List<Pais> getAll();
	public List<Pais> getByNombre (String nombre);
}

