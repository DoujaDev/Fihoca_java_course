package com.pepe.cajondesastre.practicainterface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductoServicesImplC implements ProductoServices {

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
		
		Producto p1 = new Producto(100,"Drivers Impresora Canon",f1,250.60,Familia.SOFTWARE);
		Producto p2 = new Producto(101,"ContaNerd Deluxe v2",f2,150.00,Familia.SOFTWARE);
		Producto p3 = new Producto(108,"Alfombrilla Steelseries",f3,12.00,Familia.CONSUMIBLE);
		Producto p4 = new Producto(109,"Ordenador HP M2",f4,1290.50,Familia.HARDWARE);
		Producto p5 = new Producto(116,"Ordenador HP M4",f5,1670.57,Familia.HARDWARE);
		Producto p6 = new Producto(108,"Tinta Impresora Canon",f3,50.00,Familia.CONSUMIBLE);
		
		p4.setDescatalogado(true);
		p5.setDescatalogado(true);
		
		PRODUCTOS.put(p1.getCodigo(),p1);
		PRODUCTOS.put(p2.getCodigo(),p2);
		PRODUCTOS.put(p3.getCodigo(),p3);
		PRODUCTOS.put(p4.getCodigo(),p4);
		PRODUCTOS.put(p5.getCodigo(),p5);
		PRODUCTOS.put(p6.getCodigo(),p6);
		
	}
	
	@Override
	public Producto create(Producto producto) {
		// TODO Auto-generated method stub
		Set<Integer> keys = PRODUCTOS.keySet();
		
		int newKey = 0;
		
		for(Integer key: keys) {
			
			if(key > newKey) {
				
				newKey = key;
			}
			
		}
		
		// Obteniendo key nueva y asignándola al producto
		newKey++;
		producto.setCodigo(newKey);
		
		// Añadiendo producto al map
		PRODUCTOS.put(newKey, producto);
		
		return producto;
	}

	@Override
	public Producto read(int codigo) {
		
		return PRODUCTOS.get(codigo);
		
	}
	
	@Override
	public Producto update(Producto producto) {
		
		if(PRODUCTOS.containsKey(producto.getCodigo())) {
			
			return PRODUCTOS.put(producto.getCodigo(), producto);
			
		}else {
		
			return null;
		}
		
	}

	@Override
	public Producto delete(int codigo) {

		return PRODUCTOS.remove(codigo);
	}

	@Override
	public List<Producto> getAll() {
		
		List<Producto> productos = new ArrayList<>(PRODUCTOS.values());
		
		return productos;
	}

	@Override
	public List<Producto> getByFamilia(Familia familia) {
		
		List<Producto> productos = new ArrayList<>();
		Set<Integer> keys = PRODUCTOS.keySet();
		
		for(Integer key: keys) {
			
			if(this.read(key).getFamilia() == familia) {
				
				productos.add(this.read(key));
			
			}
				
		}
		
		return productos;
	}

	@Override
	public List<Producto> getDescatalogados() {
		
		List<Producto> productos = new ArrayList<>();
		Set<Integer> keys = PRODUCTOS.keySet();
		
		for(Integer key: keys) {
			
			if(this.read(key).isDescatalogado()) {
				
				productos.add(this.read(key));
			
			}
				
		}
		
		return productos;
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		
		List<Producto> productos = new ArrayList<>();
		Set<Integer> keys = PRODUCTOS.keySet();
		
		for(Integer key: keys) {
			
			if(this.read(key).getPrecio()<= max && this.read(key).getPrecio()>= min) {
				
				productos.add(this.read(key));
			
			}
				
		}
		
		return productos;
	}

	@Override
	public List<Producto> getBetweenDates(Date desde, Date hasta) {
		// TODO Auto-generated method stub
		List<Producto> productos = new ArrayList<>();
		Set<Integer> keys = PRODUCTOS.keySet();
		
		for(Integer key: keys) {

			Date fechaProducto = new Date();
			fechaProducto = this.read(key).getFechaAlta();
			
			if(fechaProducto.compareTo(hasta) < 0 && fechaProducto.compareTo(desde) > 0) {
				
				productos.add(this.read(key));
			
			}
		
		}
		
		return productos;
	}

	@Override
	public List<Producto> getOrderedByCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfProductosByFamilia(Familia familia) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<Familia, Double> getPrecioMedio() {
		// TODO Auto-generated method stub
		return null;
	}

}
