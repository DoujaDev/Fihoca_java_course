package com.pgrsoft.demojpa.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


import com.pgrsoft.demojpa.model.Jugador;

@Service
public interface JugadorServices extends JpaRepository<Jugador, Long> {
	
	public List<Jugador> findByDorsal(int dorsal);
	
	@Query( "select a from Jugador a where LENGTH(a.nombre)< :var")
	public List<Jugador> getNombrePeque(@Param(value = "var") int variable);	

}
