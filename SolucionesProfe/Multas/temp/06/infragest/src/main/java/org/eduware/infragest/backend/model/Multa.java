package org.eduware.infragest.backend.model;

import java.util.Date;

public class Multa {
	
	private Integer codigo;
	private Date fecha;
	private String matricula;
	private double importe;
	private String motivo;
	private String agente;
	private double latitud;
	private double longitud;
	
	//Constructor
	public Multa() {
		
	}

	public Multa(Integer codigo, Date fecha, String matricula, double importe, String motivo, String agente,
			double latitud, double longitud) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.matricula = matricula;
		this.importe = importe;
		this.motivo = motivo;
		this.agente = agente;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	// Getters y setters
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getAgente() {
		return agente;
	}

	public void setAgente(String agente) {
		this.agente = agente;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}	
	
	// toString
	@Override
	public String toString() {
		return "Multa [codigo=" + codigo + ", fecha=" + fecha + ", matricula=" + matricula + ", importe=" + importe
				+ ", motivo=" + motivo + ", agente=" + agente + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}

	
	
	
	

	
	
	

}
