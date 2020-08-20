package com.projectclick.gestionsegurosvehiculo.services.impl;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.projectclick.gestionsegurosvehiculo.model.Tipo;
import com.projectclick.gestionsegurosvehiculo.model.Vehiculo;
import com.projectclick.gestionsegurosvehiculo.services.GestionSeguro;

@Service
public class GestionSeguroImpl implements GestionSeguro {

	private static final Map<String, Double> MARCAIMPORTE = new HashMap<String, Double>();
	private static final Map<Integer, Vehiculo> VEHICULOS = new HashMap<Integer, Vehiculo>();
	
	static{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		Date fecha1 = null;
		Date fecha2 = null;
		Date fecha3 = null;
			
		try {
			fecha1 = sdf.parse("18/11/2000");
			fecha2 = sdf.parse("26/05/1990");
			fecha3 = sdf.parse("07/12/2019");	
		} catch(Exception e) {
				
		}
		MARCAIMPORTE.put("Maserati",2000.0);
		MARCAIMPORTE.put("Audi",1000.0);
		MARCAIMPORTE.put("Seat",500.0);

		Vehiculo v1 = new Vehiculo(1, "Maserati", "Nitro", "Amarillo", Tipo.NUEVO,fecha1, fecha2);
		Vehiculo v2 = new Vehiculo(2, "Seat", "Familiar", "Negro", Tipo.SEGUNDA_MANO,fecha2, fecha3);
		Vehiculo v3 = new Vehiculo(3, "Audi", "Deportivo", "Naranja", Tipo.NUEVO,fecha3, fecha3);
		
		VEHICULOS.put(1, v1);
		VEHICULOS.put(2, v2);
		VEHICULOS.put(3, v3);
	}
	private LocalDate convertData(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	@Override
	public double getSeguroPrecio(Vehiculo vehiculo) {
		
		//Marca vehiculo
		if(!MARCAIMPORTE.containsKey(vehiculo.getMarca())) {
			throw new RuntimeException("Marca no existente");
		}
			
		double importe = 0.0;
		
		importe += MARCAIMPORTE.get(vehiculo.getMarca());
		
		//Modelo vehiculo
		if(vehiculo.getModelo().equals("Familiar") || vehiculo.getModelo().equals("Clasicos")){
			importe += 100;
			
		}else if (vehiculo.getModelo().equals("Nitro") || vehiculo.getModelo().equals("Deportivos")){
			importe += 300;
			
			
		}else {
			throw new RuntimeException("Modelo no existente");
		}
		
		//Color vehiculo
		if(vehiculo.getColor().equals("Negro") || vehiculo.getColor().equals("Amarillo")){
			importe += 100;
			
		}else if (vehiculo.getColor().equals("Rojo") || vehiculo.getColor().equals("Naranja")){
			importe += 300;
			
			
		}else {
			importe += 50;
		}
		
		//Fecha Nacimiento Vehiculo
		Period p = Period.between(convertData(vehiculo.getFechaNacimiento()), LocalDate.now());
		
		if(p.getYears() > 25 && p.getYears() < 60  ){
			importe += 100;
			
		}else if (p.getYears() < 25 || p.getYears() > 60  ) {
			importe += 300;
			
		}else if (p.getYears() < 18 ) {
			throw new RuntimeException("no es posible generar seguro, edad no permitida");
		
		}
		
		//Fecha Carnet vehiculo
		Period p1 = Period.between(convertData(vehiculo.getFechaCarnet()), LocalDate.now());
		
		if(p1.getYears() > 5 && p.getYears() < 60  ){
			importe += 100;
			
		}else if (p1.getYears() < 5 || p.getYears() > 60  ) {
			importe += 300;
		}
		return importe;
	}
	
	@Override
	public List<Vehiculo> getAll() {
	
		return new ArrayList<Vehiculo>(VEHICULOS.values());
	}
	
	@Override
	public Vehiculo create(Vehiculo vehiculo) {
		int maxCode = 0;
		for (Integer key: VEHICULOS.keySet()) {
			
			int code = VEHICULOS.get(key).getCodigo();
			
			if (code > maxCode) {
				maxCode = code;
			}
		}
		
		vehiculo.setCodigo(++maxCode);
		VEHICULOS.put(vehiculo.getCodigo(),vehiculo);
		return vehiculo;
	}
}
