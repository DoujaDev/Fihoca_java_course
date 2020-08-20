package Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import Repositories.ProductoRepository;
import jpaProject.jpaProject.model.Producto;

public class ProductController {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping("/productos")
	public List<Producto> getAll(){
		return productoRepository.findAll();
	}

}
