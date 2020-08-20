package com.nhoksoft.cajondesastre.practicainterface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductoServicesImplD implements ProductoServices {

	private static final Map<Integer,Producto> PRODUCTOS = new HashMap<>();
	
	static {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date f1 = null;
		Date f2 = null;
		Date f3 = null;
		Date f4 = null;
		Date f5 = null;
		Date f6 = null;
		
		try {
			f1 = sdf.parse("10/11/2016");
			f2 = sdf.parse("10/11/2016");
			f3 = sdf.parse("11/11/2016");
			f4 = sdf.parse("12/11/2016");
			f5 = sdf.parse("15/11/2016");
			f6 = sdf.parse("16/11/2016");
		} catch(Exception e) {
			
		}
		
		Producto p1 = new Producto(100,"Impresora Epson L2",f1,2.0,Familia.HARDWARE);
		Producto p2 = new Producto(101,"ContaNerd Deluxe v2",f2,10.0,Familia.SOFTWARE);
		Producto p3 = new Producto(108,"Alfombrilla Cristiano Ronaldo",f3,20.0,Familia.CONSUMIBLE);
		Producto p4 = new Producto(109,"Ordenador HP M2",f4,3.0,Familia.HARDWARE);
		Producto p5 = new Producto(116,"Ordenador HP M4",f5,4.0,Familia.HARDWARE);
		Producto p6 = new Producto(117,"Microsoft patata edition",f6,8.0,Familia.SOFTWARE);
		
		PRODUCTOS.put(p1.getCodigo(),p1);
		PRODUCTOS.put(p2.getCodigo(),p2);
		PRODUCTOS.put(p3.getCodigo(),p3);
		PRODUCTOS.put(p4.getCodigo(),p4);
		PRODUCTOS.put(p5.getCodigo(),p5);
		PRODUCTOS.put(p6.getCodigo(),p6);
		
	}
	
	@Override
	public Producto create(Producto producto) {
		
		int maxCode = 0;
		for (Integer key: PRODUCTOS.keySet()) {
			
			int code = PRODUCTOS.get(key).getCodigo();
			
			if (code > maxCode) {
				maxCode = code;
			}
			
		}
		
		producto.setCodigo(++maxCode);
		
		return PRODUCTOS.put(producto.getCodigo(),producto);
	}

	@Override
	public Producto read(int codigo) {
		return PRODUCTOS.get(codigo);
	}
	

	@Override
	public Producto update(Producto producto) {
		return PRODUCTOS.replace(producto.getCodigo(), producto);
	}

	@Override
	public Producto delete(int codigo) {
		return PRODUCTOS.remove(codigo);
	}

	@Override
	public List<Producto> getAll() {
		
		return new ArrayList<>(PRODUCTOS.values());
	}
	
	@Override
	public List<Producto> getByFamilia(Familia familia) {
		
		return PRODUCTOS.values()
				.stream()
				.filter(x -> x.getFamilia() == familia)
				.collect(Collectors.toList());    // terminal
	}
/*
	@Override
	public List<Producto> getByFamilia(Familia familia) {
		
		List<Producto> productos = new ArrayList<>();
		
		for (Integer key: PRODUCTOS.keySet()) {
			
			if (PRODUCTOS.get(key).getFamilia() == familia ) {
				productos.add(PRODUCTOS.get(key));
			}
			
		}
		
		return productos;
	}
*/
	@Override
	public List<Producto> getDescatalogados() {
		
		return PRODUCTOS.values()
				.stream()
				.filter(x -> x.isDescatalogado())
				.collect(Collectors.toList());    // terminal
	}

	/*	
	@Override
	public List<Producto> getDescatalogados() {
		
		List<Producto> productos = new ArrayList<>();
		
		for (Integer key: PRODUCTOS.keySet()) {
			
			if (PRODUCTOS.get(key).isDescatalogado()) {
				productos.add(PRODUCTOS.get(key));
			}
			
		}
		
		return productos;
	}
*/	
	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		
		return PRODUCTOS.values()
				.stream()
				.filter(x -> x.getPrecio() <= max )
				.filter(x -> x.getPrecio() >= min)
				.collect(Collectors.toList());    // terminal
	}
	
	/*	
	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		
		List<Producto> priceRangeP = new ArrayList<>();
		
		for (Integer key: PRODUCTOS.keySet()) {
			
			double precio = PRODUCTOS.get(key).getPrecio();
			if ( precio <= max && min <= precio ) {
				priceRangeP.add(PRODUCTOS.get(key));
			}
			
		}
		return priceRangeP;
	}
	*/
	
	@Override
	public List<Producto> getBetweenDates(Date desde, Date hasta) {
		
		return PRODUCTOS.values()
				.stream()
				.filter(x -> x.getFechaAlta().compareTo(desde) >= 0)
				.filter(x -> x.getFechaAlta().compareTo(hasta) <= 0)
				.collect(Collectors.toList());    // terminal
	}
	
	/*
	@Override
	public List<Producto> getBetweenDates(Date desde, Date hasta) {
		
		List<Producto> datesP = new ArrayList<>();
		
		for (Integer key: PRODUCTOS.keySet()) {
			
			Date date = PRODUCTOS.get(key).getFechaAlta();
			if ( date.compareTo(desde) >= 0 && date.compareTo(hasta) <= 0) {
				datesP.add(PRODUCTOS.get(key));
			}
			
		}
		return datesP;
	}*/
	
	@Override
	public List<Producto> getOrderedByCode() {
		
		List<Producto> productos = new ArrayList<>(PRODUCTOS.values());
		
		Collections.sort(productos,new Comparator<Producto>() {

			@Override
			public int compare(Producto a, Producto b) {
			
				return a.getCodigo() - b.getCodigo();
			}
			
		});
		
		return productos;
	}
/*
	@Override
	public List<Producto> getOrderedByCode() {
		
		List<Producto> ordByCode = new ArrayList<>();
		List<Integer> codeList = new ArrayList<>(PRODUCTOS.keySet());
		
		Collections.sort(codeList);
		
		for (Integer key: codeList) {
			ordByCode.add(PRODUCTOS.get(key));
		}
		
		return ordByCode;
	}
*/
	@Override
	public int getNumberOfProductosByFamilia(Familia familia) {
		return getByFamilia(familia).size();
	}

	@Override
	public Map<Familia, Double> getPrecioMedio() {
		
		Map<Familia, Double> mapF = new HashMap<>();
		mapF.put(Familia.CONSUMIBLE, 0.0);
		mapF.put(Familia.HARDWARE, 0.0);
		mapF.put(Familia.SOFTWARE, 0.0);
		
		int contC = 0, contH = 0, contS = 0;
		
		for (Integer key: PRODUCTOS.keySet()) {
			
			double precio = PRODUCTOS.get(key).getPrecio();
			Familia fam = PRODUCTOS.get(key).getFamilia();
			mapF.replace(fam, mapF.get(fam) + precio);
			
			if (fam == Familia.CONSUMIBLE ) contC++;
			else if (fam == Familia.HARDWARE) contH++;
			else contS++;
		}
		
		mapF.replace(Familia.CONSUMIBLE, 
				mapF.get(Familia.CONSUMIBLE)/contC);
		
		mapF.replace(Familia.HARDWARE, 
				mapF.get(Familia.HARDWARE)/contH);
		
		mapF.replace(Familia.SOFTWARE, 
				mapF.get(Familia.SOFTWARE)/contS);
		
		
		/*
		
		mapF.replace(Familia.CONSUMIBLE, 
				mapF.get(Familia.CONSUMIBLE)
				/this.getNumberOfProductosByFamilia(Familia.CONSUMIBLE));
		
		mapF.replace(Familia.HARDWARE, 
				mapF.get(Familia.HARDWARE)
				/this.getNumberOfProductosByFamilia(Familia.HARDWARE));
		
		mapF.replace(Familia.SOFTWARE, 
				mapF.get(Familia.SOFTWARE)
				/this.getNumberOfProductosByFamilia(Familia.SOFTWARE));
		*/
		
		return mapF;
	}

}
