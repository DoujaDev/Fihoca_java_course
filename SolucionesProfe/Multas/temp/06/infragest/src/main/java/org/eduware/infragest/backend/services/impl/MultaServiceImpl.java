package org.eduware.infragest.backend.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eduware.infragest.backend.model.Multa;
import org.eduware.infragest.backend.services.MultaService;
import org.springframework.stereotype.Service;

@Service
public class MultaServiceImpl implements MultaService {
	
	private static final Map<Integer,Multa> MULTAS = new HashMap<>();
	
	static {
		
		Date f1 = null;
		Date f2 = null;
		Date f3 = null;
		Date f4 = null;
		
		// "25/12/2019 23:55"   ->   Date
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		try {
			f1 = sdf.parse("25/12/2019 23:58");
			f2 = sdf.parse("26/12/2019 04:58");
			f3 = sdf.parse("27/12/2019 11:34");
			f4 = sdf.parse("31/12/2019 23:59");
		} catch (ParseException e) {
			
		}
		
		MULTAS.put(1, new Multa(1, f1, "5678-ABC", 500, "Ir lento", "Poli malo", 2.0, 41.1));
		MULTAS.put(2, new Multa(2, f2, "5678-ABC", 1, "Pisar un perro", "Poli bueno", 2.0, 41.1));
		MULTAS.put(3, new Multa(3, f3, "9834-BCN", 10000, "Tirar un papel al suelo", "Poli malo", 2.0, 41.1));
		MULTAS.put(4, new Multa(4, f4, "5118-RNB", 5, "Matar al presidente", "Poli malo", 2.0, 41.1));
	}


	@Override
	public Multa create(Multa multa) {
		int nuevoCodigo = Collections.max(MULTAS.keySet()) + 1;
		multa.setCodigo(nuevoCodigo);
		
		MULTAS.put(multa.getCodigo(), multa);
		return multa;
	}

	@Override
	public void delete(int codigo) {
		MULTAS.remove(codigo);
		System.out.println("Tranquilo, no hemos viso nada. La multa con codigo " + codigo + " ha dejado de existir");

	}

	@Override
	public List<Multa> getAll() {
		return new ArrayList<Multa>(MULTAS.values());
	}

	@Override
	public Multa getByCodigo(int codigo) {
		return MULTAS.get(codigo);
	}

	@Override
	public List<String> getTopCantidad() {
		Map<String, Long> multasAgrupadas = MULTAS.values().stream()
															.collect(Collectors.groupingBy(
																	 Multa::getMatricula, 
																	 Collectors.counting()));
		Long maxCantidad = Collections.max(multasAgrupadas.values());
		return multasAgrupadas.keySet().stream()
									   .filter(x -> multasAgrupadas.get(x) == maxCantidad)
									   .collect(Collectors.toList());
		//return null;
	}

	@Override
	public List<String> getTopImporte() {
		Map<String, Double> multasAgrupadas = MULTAS.values().stream()
															.collect(Collectors.groupingBy(
															 Multa::getMatricula, 
															 Collectors.summingDouble(Multa::getImporte)));
		Double maxImporte = Collections.max(multasAgrupadas.values());
		return multasAgrupadas.keySet().stream()
									   .filter(x -> multasAgrupadas.get(x) == maxImporte)
									   .collect(Collectors.toList());
	}

	@Override
	public List<Multa> getByAgente(String agente) {
		return MULTAS.values().stream()
		.filter(x -> x.getAgente().equals(agente))
		.collect(Collectors.toList());
		
	}

	@Override
	public List<Multa> getByPriceRange(double min, double max) {
		return MULTAS.values().stream()
				.filter(x -> x.getImporte() > min && x.getImporte() < max)
				.collect(Collectors.toList());
	}

}
