package com.pgrsoft.demojpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MULTAS")
public class Multa {
	@Id
	@Column(name="CODIGO")
	private Long codigo;
	
	@Column(name="NOMBRE_AGENTE")
	private String nombre_agente;
	
	@Column(name="MATRICULA")
	private String matricula;
	
	@Column(name="MOTIVO")
	private String motivo;
	
	@Column(name="IMPORTE")
	private double importe;
	
	public Multa() {
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre_agente() {
		return nombre_agente;
	}

	public void setNombre_agente(String nombre_agente) {
		this.nombre_agente = nombre_agente;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "Multa [codigo=" + codigo + ", nombre_agente=" + nombre_agente + ", matricula=" + matricula + ", motivo="
				+ motivo + ", importe=" + importe + "]";
	}

}
