package com.mms.infragest.model;

import java.util.Date;

public class Multa {

	public Integer codigo;
	public Date fecha;
	public String nombreAgente;
	public String matricula;
	public double importe;
	public String motivo;
	public double longitud;
	public double latitud;
	
	public Multa() {
		
	}
	
	public Multa(Integer codigo, Date fecha, String nombreAgente, String matricula, double importe, String motivo,
			double longitud, double latitud) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.nombreAgente = nombreAgente;
		this.matricula = matricula;
		this.importe = importe;
		this.motivo = motivo;
		this.longitud = longitud;
		this.latitud = latitud;
	}

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
	public String getNombreAgente() {
		return nombreAgente;
	}
	public void setNombreAgente(String nombreAgente) {
		this.nombreAgente = nombreAgente;
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
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	@Override
	public String toString() {
		return "Multa [codigo=" + codigo + ", fecha=" + fecha + ", nombreAgente=" + nombreAgente + ", matricula="
				+ matricula + ", importe=" + importe + ", motivo=" + motivo + ", longitud=" + longitud + ", latitud="
				+ latitud + "]";
	}
	
	
}
