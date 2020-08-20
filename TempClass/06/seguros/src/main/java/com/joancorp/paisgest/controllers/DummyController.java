package com.joancorp.paisgest.controllers;

public class DummyController {

	public PrecioJSON getPrecio() {
		
		PrecioJSON precio = new PrecioJSON(100);
		
		return precio;
		
	}
	
	
	class PrecioJSON{
		private double precio;
		
		public PrecioJSON(double precio) {
			this.precio = precio;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}
		
	}
	
}
