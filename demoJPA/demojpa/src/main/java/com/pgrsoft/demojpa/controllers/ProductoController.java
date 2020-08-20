package com.pgrsoft.demojpa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.demojpa.model.Producto;
import com.pgrsoft.demojpa.services.ProductoServices;

@RestController
public class ProductoController {
	
	@Autowired
	private ProductoServices productoServices;
	
	// 1.- endpoint
	
	@GetMapping("/productos")
	public List<Producto> getAll(){
		return productoServices.findAll();
	}
	
	// 2.- endpoint
	
	@GetMapping("/productos/{code}")
	public Producto getByCode(@PathVariable("code") Long codigo) {
		
		Optional<Producto> optional = productoServices.findById(codigo);
	
		Producto producto = null;
		
		if(optional.isPresent()) {
			producto = optional.get();
		}
		
		return producto;
		
		//return optional.isPresent()? optional.get() : null;
	}
	
	// 3.- endpoint
	
	@PostMapping("/productos")
	public Producto crear(@RequestBody Producto producto) {
		return productoServices.save(producto);
	}
	
	
	// 4.- endpoint
	
	@DeleteMapping("/productos/{code}")
	public String eliminar(@PathVariable("code") Long codigo) {
		
		productoServices.deleteById(codigo);
		
		return "ok, producto " + codigo + "liminado";
	}
	
	// 5.- endpoint
	
	@PutMapping("/productos")
	public Producto actualizar(@RequestBody Producto producto) {
		
		// El producto que actualizamos debe tener una ID en el sistema!
		
		return productoServices.save(producto);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
