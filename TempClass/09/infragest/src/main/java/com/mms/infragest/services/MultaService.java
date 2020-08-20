package com.mms.infragest.services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.mms.infragest.model.Multa;

public interface MultaService {

	// Retorna una multa con código establecido por el "sistema"
	public Multa create(Multa multa);
	public Multa eliminate(Integer codigo);
	public List<Multa> getAll();
	public Multa getByID(Integer codigo);
	public List<Multa> getByNombre(String nombre);
	public List<Multa> getByPrecio(double min, double max);
	public String getMasMultado();
	public String getMasAlta();
	
}
