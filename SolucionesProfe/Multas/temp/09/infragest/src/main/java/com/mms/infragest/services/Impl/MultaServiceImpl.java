package com.mms.infragest.services.Impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.catalina.connector.CoyoteWriter;

import com.mms.infragest.model.Multa;
import com.mms.infragest.services.MultaService;

public class MultaServiceImpl implements MultaService {
	
	private static final Map<Integer, Multa> MULTAS = new HashMap<>();
	
	static {
		// inicializamos con datosmplo
	}

	@Override
	public Multa create(Multa multa) {
		
		// Necesitamos calcular el código (buscar el código máximo e incrementarlo en 1
		
		Set<Integer> keys = MULTAS.keySet();
		int codigoMasAlto = 0;
		for(Integer key: keys) {
			if(key.intValue() > codigoMasAlto) {
				codigoMasAlto = key.intValue();
			}
		}
		
		multa.setCodigo(codigoMasAlto);
		
		MULTAS.put(codigoMasAlto, multa); // CREATE
		
		return multa;

	}

	@Override
	public Multa eliminate(Integer codigo) {
		Multa aEliminar = MULTAS.get(codigo);
		MULTAS.remove(codigo);
		return aEliminar;
	}

	@Override
	public List<Multa> getAll() {
		return new ArrayList<Multa>(MULTAS.values());
	}

	@Override
	public Multa getByID(Integer codigo) {	
		return MULTAS.get(codigo);
	}

	@Override
	public List<Multa> getByNombre(String nombre) {
		Set<Integer> keys = MULTAS.keySet();
		List<Multa> listaMultasPorNombre = new LinkedList<>();
		for(Integer key: keys) {
			if(MULTAS.get(key).nombreAgente == nombre) {
				listaMultasPorNombre.add(MULTAS.get(key));
			}
		} 
		return listaMultasPorNombre;
	}

	@Override
	public List<Multa> getByPrecio(double min, double max) {
		Set<Integer> keys = MULTAS.keySet();
		List<Multa> listaMultasPorPrecio = new LinkedList<>();
		for(Integer key: keys) {
			if(MULTAS.get(key).importe > min && MULTAS.get(key).importe < max) {
				listaMultasPorPrecio.add(MULTAS.get(key));
			}
		} 
		return listaMultasPorPrecio;
	}

	@Override
	public String getMasMultado() {
		//Passem totes les multes a una colecció
		Collection<Multa> multas = MULTAS.values();
		
		//Creem un mapa buit de matrícula i nombre de cops que ha estat multada
		Map<String,Integer> cantidad = new HashMap<>();
		
		//Creem un set de matrícules del mapa anterior
		Set<String> plates = cantidad.keySet();
		
		for(Multa ticket: multas) {
			String matricula = ticket.matricula;
			for(String plate: plates) {
				if(matricula == plate) {
					int i = cantidad.get(plate);
					i = i + 1;
				} else {
					cantidad.put(plate, 1);
				}				
			}			
		}
		
		String matriculaGanadora = "";
		int masAlto = 0;
		
		for(String plate: plates) {
			int i = cantidad.get(plate);
			if(i > masAlto) {
				masAlto = i;
				matriculaGanadora = plate;
			}
		}
		
		return matriculaGanadora;
	}

	@Override
	public String getMasAlta() {
		//Passem totes les multes a una colecció
		Collection<Multa> multas = MULTAS.values();
		int multaMasAlta;
		String matricula = "";
		for(Multa ticket: multas) {
			
		}
		
		
		return null;
	}

}
