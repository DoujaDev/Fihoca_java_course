package com.pgrsoft.fihoca2019.cajondesastre.practicacollections;

public class TestClass {

	private ProductoServices productoServices = new ProductoServicesImpl();
	
	private void run() {
		
		Producto producto = productoServices.read(100);
		System.out.println(producto);
		
	}
	
	public static void main(String[] args) {
		new TestClass().run();
	}

}
