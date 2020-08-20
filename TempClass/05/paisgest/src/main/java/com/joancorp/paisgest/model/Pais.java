package com.joancorp.paisgest.model;

public class Pais {

	private String pais;
	private String capital;
	private int numeroFronteras;
	private int numeroIdiomas;
	private int poblacion;
	
	public Pais() {
		
	}

	public Pais(String pais, String capital, int numeroFronteras, int numeroIdiomas, int poblacion) {
		super();
		this.pais = pais;
		this.capital = capital;
		this.numeroFronteras = numeroFronteras;
		this.numeroIdiomas = numeroIdiomas;
		this.poblacion = poblacion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getNumeroFronteras() {
		return numeroFronteras;
	}

	public void setNumeroFronteras(int numeroFronteras) {
		this.numeroFronteras = numeroFronteras;
	}

	public int getNumeroIdiomas() {
		return numeroIdiomas;
	}

	public void setNumeroIdiomas(int numeroIdiomas) {
		this.numeroIdiomas = numeroIdiomas;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	@Override
	public String toString() {
		return "Pais [pais=" + pais + ", capital=" + capital + ", numeroFronteras=" + numeroFronteras
				+ ", numeroIdiomas=" + numeroIdiomas + ", poblacion=" + poblacion + "]";
	}

}