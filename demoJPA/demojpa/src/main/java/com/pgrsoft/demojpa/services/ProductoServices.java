package com.pgrsoft.demojpa.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.pgrsoft.demojpa.model.Producto;

// New!!!

// 1.- Vamos a hacer que este interface extienda otro ya existente de Spring Data
// 2.- Vamos a utilizar la anotación @Service

@Service
public interface ProductoServices extends JpaRepository<Producto, Long> {
	
}
