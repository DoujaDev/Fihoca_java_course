package com.projectclick.cajondesastre.practicacollections;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductoServicesImplB implements ProductoServices {

	private static final Map<Integer,Producto> PRODUCTOS = new HashMap<>();
	
	static {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		Date f1 = null;
		Date f2 = null;
		Date f3 = null;
		Date f4 = null;
		Date f5 = null;
		
		try {
			f1 = sdf.parse("10/11/2016");
			f2 = sdf.parse("9/11/2016");
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
		p5.setDescatalogado(true);
		
		PRODUCTOS.put(p1.getCodigo(),p1);
		PRODUCTOS.put(p2.getCodigo(),p2);
		PRODUCTOS.put(p3.getCodigo(),p3);
		PRODUCTOS.put(p4.getCodigo(),p4);
		PRODUCTOS.put(p5.getCodigo(),p5);
		
	}
	
	@Override
	public Producto create(Producto producto) {
		
		int maxkey = Collections.max(PRODUCTOS.keySet());
		int productokey = maxkey + 1;
		producto.setCodigo(productokey);
		PRODUCTOS.put(productokey, producto);
		return producto;
		
	}

	@Override
	public Producto read(int codigo) {
		return PRODUCTOS.get(codigo);
	}
	

	@Override
	public Producto update(Producto producto) {
		
		Set<Integer> keys = PRODUCTOS.keySet();
		
		if(keys.contains(producto.getCodigo())== true ) {
			PRODUCTOS.put(producto.getCodigo(), producto);
			
		}
		
		return producto;
	}

	@Override
	public Producto delete(int codigo) {
		PRODUCTOS.remove(codigo);
		return null;
	}

	@Override
	public void print() {
		Set<Integer> keys = PRODUCTOS.keySet();
		
		for(Integer key: keys) {
			System.out.println((PRODUCTOS.get(key)));
		}
		
	}
	
	@Override
	public List<Producto> getAll() {
		
		List<Producto> listaProducto = new ArrayList<>(PRODUCTOS.values());
		
		return listaProducto;
	}

	@Override
	public List<Producto> getByFamilia(Familia familia) {
		
		List<Producto> listaByFamilia = new ArrayList<>();
		
		Set<Integer> keys = PRODUCTOS.keySet();
		
		for(Integer key: keys) {
			Producto producto = PRODUCTOS.get(key);
			if (producto.getFamilia() == familia) {
				listaByFamilia.add(producto);
			}
		}
		return listaByFamilia;
	}

	@Override
	public List<Producto> getDescatalogados() {
		List<Producto> listaDescatalogados = new ArrayList<>();
		
		Set<Integer> keys = PRODUCTOS.keySet();
		
		for(Integer key: keys) {
			Producto producto = PRODUCTOS.get(key);
			if (producto.isDescatalogado() == true) {
				listaDescatalogados.add(producto);
			}
		}
		return listaDescatalogados;
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		List<Producto> listaBetweenPriceRange = new ArrayList<>();
		
		Set<Integer> keys = PRODUCTOS.keySet();
		
		for(Integer key: keys) {
			Producto producto = PRODUCTOS.get(key);
			if (producto.getPrecio() >= min && producto.getPrecio() <= max) {
				listaBetweenPriceRange.add(producto);
			}
		}
		return listaBetweenPriceRange;
	}

	@Override
	public List<Producto> getBetweenDates(Date desde, Date hasta) {
		List<Producto> listaBetweenDates = new ArrayList<>();
		
		Set<Integer> keys = PRODUCTOS.keySet();
		
		for(Integer key: keys) {
			Producto producto = PRODUCTOS.get(key);
			if (producto.getFechaAlta().compareTo(desde) > 0 && producto.getFechaAlta().compareTo(hasta) < 0) {
				listaBetweenDates.add(producto);
			}
		}
		return listaBetweenDates;
	}

	@Override
	public List<Producto> getOrderedByCode() {
		Set<Integer> keys = PRODUCTOS.keySet();
		
		List<Integer> listaKeys = new ArrayList<>();
		
		for(Integer key: keys) {
			listaKeys.add(key);
			}
		
		Collections.sort(listaKeys);
		
		List<Producto> listaOrderedByCode = new ArrayList<>();
		
		for(Integer key: listaKeys) {
			listaOrderedByCode.add(PRODUCTOS.get(key));
			}
		
		return listaOrderedByCode;
	}

	@Override
	public int getNumberOfProductosByFamilia(Familia familia) {
		return getByFamilia(familia).size();
	}

	
	@Override
	public Map<Familia, Double> getPrecioMedio() {
		/*
		Map<String,Double> mapPrecioMedio = new HashMap<>();
		
		List<Producto> listaHarware = new getByFamilia(Familia.HARDWARE);
		
		for(Integer key: keys) {
			Producto producto = PRODUCTOS.get(key);
		
		*/
		return null;
	}
	

}
