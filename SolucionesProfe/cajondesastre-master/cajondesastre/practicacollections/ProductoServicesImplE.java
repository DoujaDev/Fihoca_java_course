package com.pgrsoft.fihoca2019.cajondesastre.practicacollections;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductoServicesImplE implements ProductoServices {

	private static final Map<Integer,Producto> PRODUCTOS = new HashMap<>();
	
	static {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date f1 = null;
		Date f2 = null;
		Date f3 = null;
		Date f4 = null;
		Date f5 = null;
		
		try {
			f1 = sdf.parse("32/01/2016");
			f2 = sdf.parse("10/11/2016");
			f3 = sdf.parse("11/11/2016");
			f4 = sdf.parse("12/11/2016");
			f5 = sdf.parse("15/11/2016");
		} catch(Exception e) {
			
		}
		
		Producto p1 = new Producto(100,"Impresora Epson L2",f1,250.60,Familia.HARDWARE);
		Producto p2 = new Producto(101,"ContaNerd Deluxe v2",f2,150.00,Familia.SOFTWARE);
		Producto p3 = new Producto(108,"Alfombrilla del C.Tangana",f3,12.00,Familia.CONSUMIBLE);
		Producto p4 = new Producto(109,"Ordenador HP M2",f4,1290.50,Familia.HARDWARE);
		Producto p5 = new Producto(116,"Ordenador HP M4",f5,1670.57,Familia.HARDWARE);
		p5.setDescatalogado(true);
		p4.setDescatalogado(true);
	
		PRODUCTOS.put(p1.getCodigo(),p1);
		PRODUCTOS.put(p2.getCodigo(),p2);
		PRODUCTOS.put(p3.getCodigo(),p3);
		PRODUCTOS.put(p4.getCodigo(),p4);
		PRODUCTOS.put(p5.getCodigo(),p5);
		
	}
	
	@Override
	public Producto create(Producto producto) {
		List<Integer> listaKeys = new ArrayList<Integer>(PRODUCTOS.keySet());
		int alto = 0;
		for(Integer key: listaKeys) {
			if(key > alto) {
				alto = key;
			}
		}
		
		producto.setCodigo(alto + 1);
		PRODUCTOS.put(producto.getCodigo(), producto);
		return producto;
	}

	@Override
	public Producto read(int codigo) {
		return PRODUCTOS.get(codigo);
	}
	

	@Override
	public Producto update(Producto producto) {
		PRODUCTOS.remove(producto.getCodigo());
		PRODUCTOS.put(producto.getCodigo(), producto);
		return producto;
	}

	@Override
	public Producto delete(int codigo) {
		PRODUCTOS.remove(codigo);
		return PRODUCTOS.get(codigo);
	}

	@Override
	public List<Producto> getAll() {
		
		//List<Producto> listaProductos = new ArrayList<Producto>(PRODUCTOS.values());
		
		return new ArrayList<Producto>(PRODUCTOS.values());
	}

	@Override
	public List<Producto> getByFamilia(Familia familia) {
		
		List<Producto> listaProductos = new ArrayList<Producto>(PRODUCTOS.values());
		
		List<Producto> listaFamilia = new ArrayList<>();
		
		for(Producto producto : listaProductos) {
			if(producto.getFamilia().equals(familia)) {
				listaFamilia.add(producto);
			}
		}
		
		return listaFamilia;
	}

	@Override
	public List<Producto> getDescatalogados() {
		
		List<Producto> listaProductos = new ArrayList<Producto>(PRODUCTOS.values());
		List<Producto> listaDescatalogados = new ArrayList<>();
		
		for(Producto producto : listaProductos) {
			if(producto.isDescatalogado()) {
				listaDescatalogados.add(producto);
			}
		}
		
		return listaDescatalogados;
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		
		List<Producto> listaProductos = new ArrayList<Producto>(PRODUCTOS.values());
		List<Producto> listaPrecio = new ArrayList<>();
		
		for(Producto producto : listaProductos) {
			if(producto.getPrecio() > min && producto.getPrecio() < max) {
				listaPrecio.add(producto);
			}
		}
		return listaPrecio;

	}

	@Override
	public List<Producto> getBetweenDates(Date desde, Date hasta) {
		
		List<Producto> listaProductos = new ArrayList<Producto>(PRODUCTOS.values());
		List<Producto> listaFecha = new ArrayList<>();
		
		for(Producto producto : listaProductos) {
			if(producto.getFechaAlta().after(desde) && producto.getFechaAlta().before(hasta)) {
				
				listaFecha.add(producto);
			}
		}
	
		return listaFecha;
	}

	@Override
	public List<Producto> getOrderedByCode() {
		throw new RuntimeException("not implemented yet...");
	}

	@Override
	public int getNumberOfProductosByFamilia(Familia familia) {
		
		return this.getByFamilia(familia).size();
	}

	@Override
	public Map<Familia, Double> getPrecioMedio() {
		
		Familia listaFamilias[] = Familia.values();
		Map<Familia, Double> mapaPrecioMedio = new HashMap<>();
		
		for(Familia familia: listaFamilias) {
			
			double totalPrecio = 0;
			double precioMedio = 0;
			int numeroProductos = getNumberOfProductosByFamilia(familia);
			List<Producto> listaProductos = getByFamilia(familia);
			
			for(Producto producto: listaProductos) {
				totalPrecio += producto.getPrecio(); 
			}
			
			precioMedio = totalPrecio / numeroProductos;
			
			if(numeroProductos == 0) {
				precioMedio = 0;
			}
			
			mapaPrecioMedio.put(familia, precioMedio);
		}
		 
		return mapaPrecioMedio;
	}

}
