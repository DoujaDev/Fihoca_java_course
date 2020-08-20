package org.eduware.infragest.backend.services;

import java.util.List;

import org.eduware.infragest.backend.model.Multa;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public interface MultaService {
	
	public Multa create(Multa multa);
	
	public void delete(int codigo);
	
	public List<Multa> getAll();
	
	public Multa getByCodigo(int codigo);
	
	public List<Multa> getByAgente(String agente);
	
	public List<Multa> getByPriceRange(double min, double max) ; // Rango de precios
	
	public List<String> getTopCantidad();
	
	public List<String> getTopImporte();
	
}
