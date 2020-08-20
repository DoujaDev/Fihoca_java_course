package com.fomentoformacion.gestionproductos.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fomentoformacion.gestionproductos.model.Familia;
import com.fomentoformacion.gestionproductos.model.Producto;
import com.fomentoformacion.gestionproductos.services.ProductoServices;

@Service
public class ProductoServicesImpl implements ProductoServices {
	
	private static final Map<Integer, Producto> PRODUCTOS = new HashMap<Integer, Producto>();
	
	static {
		
		Producto p1 = new Producto(1,"Ordenador Epson Z200",860.0, Familia.HARDWARE,new Date());
		Producto p2 = new Producto(2,"Cartucho Toner 2A",45.25, Familia.CONSUMIBLE,new Date());
		Producto p3 = new Producto(3,"Portátil HP R20",1290.0, Familia.HARDWARE,new Date());
		Producto p4 = new Producto(4,"ContaNerd Lite v.4",50.0, Familia.SOFTWARE,new Date());
		Producto p5 = new Producto(5,"ContaNerd Deluxe v.4",270.0, Familia.SOFTWARE,new Date());
		Producto p6 = new Producto(6,"Alfombrilla Mouse F.C.Barcelona",25.0, Familia.CONSUMIBLE,new Date());
		Producto p7 = new Producto(7,"Alfombrilla Mouse Real Madrid",25.0, Familia.CONSUMIBLE,new Date());
		Producto p8 = new Producto(8,"Alfombrilla Mouse R.C.D Espanyol",2.0, Familia.CONSUMIBLE,new Date());
		Producto p9 = new Producto(9,"Impresora Epson 2P Plus",340.0, Familia.HARDWARE,new Date());
		Producto p10 = new Producto(10,"StopVirus v-2",23.7, Familia.SOFTWARE,new Date());
		Producto p11 = new Producto(11,"Ratón FastWeel Acme",12.0, Familia.CONSUMIBLE,new Date());
		Producto p12 = new Producto(12,"Cartucho Tinta B/W Ep100",17.0, Familia.CONSUMIBLE,new Date());
		Producto p13 = new Producto(13,"Ordenador PC-CLONE Tritón 7i 8Gb",2560, Familia.HARDWARE,new Date());
		Producto p14 = new Producto(14,"Ordenador PC-CLONE Tritón TurtleFast 5i 4Gb",1260.0, Familia.HARDWARE,new Date());
		Producto p15 = new Producto(15,"Impresora Noti-FixIS 2D",70.5, Familia.HARDWARE,new Date());
		Producto p16 = new Producto(16,"Funda Skin para laptop Teletubbies",10.0, Familia.CONSUMIBLE,new Date());
		Producto p17 = new Producto(17,"Funda Skin para laptop Dora la Exploradora",10.0, Familia.CONSUMIBLE,new Date());
		Producto p18 = new Producto(18,"Impresora multifunción Epson 2T",520.85, Familia.HARDWARE,new Date());
		Producto p19 = new Producto(19,"4 Pilas A4 Duracell",11.0, Familia.CONSUMIBLE,new Date());
		Producto p20 = new Producto(20,"Ordenador Quantum i7 8Gb 2Tb",2500.0, Familia.HARDWARE,new Date());
		
		
		PRODUCTOS.put(p1.getCodigo(),p1);
		PRODUCTOS.put(p2.getCodigo(),p2);
		PRODUCTOS.put(p3.getCodigo(),p3);
		PRODUCTOS.put(p4.getCodigo(),p4);
		PRODUCTOS.put(p5.getCodigo(),p5);
		PRODUCTOS.put(p6.getCodigo(),p6);
		PRODUCTOS.put(p7.getCodigo(),p7);
		PRODUCTOS.put(p8.getCodigo(),p8);
		PRODUCTOS.put(p9.getCodigo(),p9);
		PRODUCTOS.put(p10.getCodigo(),p10);
		PRODUCTOS.put(p11.getCodigo(),p11);
		PRODUCTOS.put(p12.getCodigo(),p12);
		PRODUCTOS.put(p13.getCodigo(),p13);
		PRODUCTOS.put(p14.getCodigo(),p14);
		PRODUCTOS.put(p15.getCodigo(),p15);
		PRODUCTOS.put(p16.getCodigo(),p16);
		PRODUCTOS.put(p17.getCodigo(),p17);
		PRODUCTOS.put(p18.getCodigo(),p18);
		PRODUCTOS.put(p19.getCodigo(),p19);
		PRODUCTOS.put(p20.getCodigo(),p20);
		
	}
	
	@Override
	public Producto create(Producto producto) {
		
		PRODUCTOS.put(producto.getCodigo(), producto);
		return producto;
	}

	@Override
	public Producto read(int codigo) {
		
		return PRODUCTOS.get(codigo);
	}
	
	@Override
	public boolean delete(int codigo) {
		
		Producto p = this.read(codigo);
		return PRODUCTOS.remove(codigo, p);
	}

	@Override
	public List<Producto> getAll() {
		
		List<Producto> arrayProductos = new ArrayList<Producto>(PRODUCTOS.values());
		return arrayProductos;
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		
		List<Producto> arrayProductos = new ArrayList<Producto>();
		List<Producto> arrayMapaProductos =  new ArrayList<Producto>(PRODUCTOS.values()); 
		for (Producto producto : arrayMapaProductos) {
			if(producto.getPrecio() > min && producto.getPrecio() < max ) {
				arrayProductos.add(producto);
			}	
		}
		return arrayProductos;
	}

	@Override
	public List<Producto> getByFamilia(Familia familia) {
		List<Producto> arrayProductos = new ArrayList<Producto>();
		List<Producto> arrayMapaProductos =  new ArrayList<Producto>(PRODUCTOS.values());
		for (Producto producto : arrayMapaProductos) {
			if(producto.getFamilia().equals(familia)) {
				arrayProductos.add(producto);
			}	
		}
		return arrayProductos;
	}

	@Override
	public List<Producto> getBetweenDates(Date desde, Date hasta) {
		
		List<Producto> arrayProductos = new ArrayList<Producto>();
		List<Producto> arrayMapaProductos =  new ArrayList<Producto>(PRODUCTOS.values());
		for (Producto producto : arrayMapaProductos) {
			if(producto.getFechaAlta().after(desde) && producto.getFechaAlta().before(hasta) ) {
				arrayProductos.add(producto);
			}	
		}
		return arrayProductos;
	}

	@Override
	public int numberOfProductos() {
		
		return PRODUCTOS.size();
	}

	@Override
	public Map<String, Integer> getFamiliaQuantities() {
		
		Map<String, Integer> mapProductosbyFamilia = new HashMap<String, Integer>();
		
		for (Map.Entry<Integer, Producto> entrada : PRODUCTOS.entrySet()) {
			List<Producto> arrayProductos = this.getByFamilia(entrada.getValue().getFamilia());
			mapProductosbyFamilia.put(entrada.getValue().getFamilia().toString(),arrayProductos.size());
		}
		
		return mapProductosbyFamilia;
	}

}
