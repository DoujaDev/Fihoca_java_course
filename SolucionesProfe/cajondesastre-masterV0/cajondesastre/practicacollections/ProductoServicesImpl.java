package com.pgrsoft.fihoca2019.cajondesastre.practicacollections;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import static java.util.stream.Collectors.*;

public class ProductoServicesImpl implements ProductoServices {

	private static final Map<Integer,Producto> PRODUCTOS = new HashMap<>();
	
	static {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date f1 = null;
		Date f2 = null;
		Date f3 = null;
		Date f4 = null;
		Date f5 = null;
		
		try {
			f1 = sdf.parse("10/11/2016");
			f2 = sdf.parse("10/11/2016");
			f3 = sdf.parse("11/11/2016");
			f4 = sdf.parse("12/11/2016");
			f5 = sdf.parse("15/11/2016");
		} catch(Exception e) {
			
		}
		
		Producto p1 = new Producto(100,"Impresora Epson L2",f1,250.60,Familia.HARDWARE);
		Producto p2 = new Producto(101,"ContaNerd Deluxe v2",f2,150.00,Familia.SOFTWARE);
		Producto p3 = new Producto(108,"Alfombrilla Cristiano Ronaldo",f3,12.00,Familia.CONSUMIBLE);
		Producto p4 = new Producto(109,"Ordenador HP M2",f4,1290.50,Familia.HARDWARE);
		Producto p5 = new Producto(116,"Ordenador HP M4",f5,1670.57,Familia.HARDWARE);
		
		PRODUCTOS.put(p1.getCodigo(),p1);
		PRODUCTOS.put(p2.getCodigo(),p2);
		PRODUCTOS.put(p3.getCodigo(),p3);
		PRODUCTOS.put(p4.getCodigo(),p4);
		PRODUCTOS.put(p5.getCodigo(),p5);
		
	}
	
	@Override
	public Producto create(Producto producto) {
		TreeSet<Integer> keys = new TreeSet<>(PRODUCTOS.keySet());
		int newKey = keys.last() + 1;
		producto.setCodigo(newKey);
		return PRODUCTOS.put(producto.getCodigo(), producto);
	}

	@Override
	public Producto read(int codigo) {
		return PRODUCTOS.get(codigo);
	}
	
	@Override
	public Producto update(Producto producto) {
		
		if (PRODUCTOS.containsKey(producto.getCodigo())) {
			PRODUCTOS.put(producto.getCodigo(), producto);
		}
		
		return PRODUCTOS.get(producto.getCodigo());
	}

	@Override
	public Producto delete(int codigo) {
		return PRODUCTOS.remove(codigo);
	}

	@Override
	public List<Producto> getAll() {
		return new ArrayList<Producto>(PRODUCTOS.values());
	}

	@Override
	public List<Producto> getByFamilia( Familia familia) {

		return PRODUCTOS.values()
				.stream()
				.filter(x -> x.getFamilia() == familia)
				.collect(toList());

	}

	@Override
	public List<Producto> getDescatalogados() {
		
		return PRODUCTOS.values()
				.stream()
				.filter(x -> x.isDescatalogado())
				.collect(toList());
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getBetweenDates(Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getOrderedByCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfProductosByFamilia(Familia familia) {
		
		return (int) PRODUCTOS.values()
				.parallelStream()
				.filter(x -> x.getFamilia() == familia)
				.count();
	}

	@Override
	public Map<Familia, Double> getPrecioMedio() {
		
		return PRODUCTOS.values()
				.stream()
		        .collect(groupingBy(Producto::getFamilia, averagingDouble(Producto::getPrecio)));
	}

}
