package com.empresaa.paises.model;


public class Pais  {

	private String name;
	private String capital;
	private int borders;
	private int languages;
	private Integer population;

	
	public Pais () {
		
	}
	
	public void convert(RestPais restPais) {
		//Pais pais = new Pais();
		this.name = restPais.getName();
		this.capital = restPais.getCapital();
		this.borders = restPais.getBorders().size();
		this.languages = restPais.getLanguages().size();
		this.population = restPais.getPopulation();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getBorders() {
		return borders;
	}

	public void setBorders(int borders) {
		this.borders = borders;
	}

	public int getLanguages() {
		return languages;
	}

	public void setLanguages(int languages) {
		this.languages = languages;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Pais [name=" + name + ", capital=" + capital + ", borders=" + borders + ", languages=" + languages
				+ ", population=" + population + "]";
	}

	
}
