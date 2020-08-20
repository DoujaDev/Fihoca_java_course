package com.pgrsoft.fihoca2019.cajondesastre.practicacollections;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import static java.util.stream.Collectors.*;

public class ProductoServicesImplA implements ProductoServices {

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
		Producto productoNuevo = new Producto(newKey,producto.getNombre(),producto.getFechaAlta(),producto.getPrecio(),producto.getFamilia());
		PRODUCTOS.put(newKey, productoNuevo);
		
		return productoNuevo;
	}

	@Override
	public Producto read(int codigo) {
		
		return PRODUCTOS.get(codigo);
	}
	

	@Override
	public Producto update(Producto producto) {
		
		int codigo = producto.getCodigo();
		PRODUCTOS.replace(codigo, producto);
		
		return producto;
	}

	@Override
	public Producto delete(int codigo) {
		
		PRODUCTOS.remove(codigo);
		
		return PRODUCTOS.get(codigo);
	}

	@Override
	public List<Producto> getAll() {
		
		List<Producto> todosProductos = new ArrayList<>(PRODUCTOS.values());
		//System.out.println("La lista de productos es: " + PRODUCTOS.toString());
		
		return todosProductos;
	}

	@Override
	public List<Producto> getByFamilia(Familia familia) {
		
		List<Producto> productosByFamilia = new ArrayList<>();
		
		PRODUCTOS.values().stream().forEach(x -> {
			if (x.getFamilia() == familia) {
				productosByFamilia.add(x);
			}
		});
		
		return productosByFamilia;
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

		return PRODUCTOS.values()
				.stream()
				.filter(x -> x.getPrecio() > min && x.getPrecio() < max)
				.collect(toList());
	}
/*	
	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		
		List<Producto> productosEnRango = new ArrayList<>();
		
		PRODUCTOS.values().stream().forEach(x -> {
			if ((x.getPrecio() > min) && (x.getPrecio() < max) ) {
				productosEnRango.add(x);
			}
		});
		
		return productosEnRango;
	}
*/
	@Override
	public List<Producto> getBetweenDates(Date desde, Date hasta) {
		return PRODUCTOS.values()
				.stream()
				.filter(x -> x.getFechaAlta().after(desde) && x.getFechaAlta().before(hasta))
				.collect(toList());
	}

	@Override
	public List<Producto> getOrderedByCode() {
		
		List<Producto> productosOrdenadosCodigo = new ArrayList<>();
		TreeSet<Integer> keys = new TreeSet<>(PRODUCTOS.keySet());
		
		for(Integer key:keys) {
			productosOrdenadosCodigo.add(PRODUCTOS.get(key));
		}
		
		return productosOrdenadosCodigo;
	}

	@Override
	public int getNumberOfProductosByFamilia(Familia familia) {

		return (int) PRODUCTOS.values()
				.stream()
				.filter(x -> x.getFamilia() == familia)
				.count();
		
	}
	
	@Override
	public Map<Familia, Double> getPrecioMedio() {

		return PRODUCTOS.values()
				.stream()
				.collect(
						groupingBy(
								Producto::getFamilia,averagingDouble(Producto::getPrecio)));
	}

}
