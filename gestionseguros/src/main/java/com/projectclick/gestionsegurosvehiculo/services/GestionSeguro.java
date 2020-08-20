package com.projectclick.gestionsegurosvehiculo.services;


import java.util.List;
import com.projectclick.gestionsegurosvehiculo.model.Vehiculo;

public interface GestionSeguro {

	public double getSeguroPrecio(Vehiculo vehiculo);
	public List<Vehiculo> getAll();
	public Vehiculo create(Vehiculo vehiculo);
	
	
}
