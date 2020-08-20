package com.pgrsoft.demojpa.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.pgrsoft.demojpa.model.Alumno;

@Service
public interface AlumnoServices extends JpaRepository<Alumno, Long> {

}
