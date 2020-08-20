package com.fomentoformacion.gestionproductos.services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fomentoformacion.gestionproductos.model.Familia;
import com.fomentoformacion.gestionproductos.model.Producto;

public interface ProductoServices {
	
	public Producto create(Producto producto);	
	public Producto read(int codigo);			
	public boolean delete(int codigo);			
	
	public List<Producto> getAll();				
	public List<Producto> getBetweenPriceRange(double min, double max); 
	public List<Producto> getByFamilia(Familia familia);				
	public List<Producto> getBetweenDates(Date desde, Date hasta);		

	public int numberOfProductos();	
	
	public Map<String,Integer> getFamiliaQuantities(); 
	
}
