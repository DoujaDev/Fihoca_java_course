package com.joancorp.paisgest.model;

import java.util.Arrays;

public class PaisRest {

	private String name;
	private String capital;
	private String[] borders;
	private Language[] languages;
	private Integer population;
	
	public PaisRest() {}

	public PaisRest(String name, String capital, String[] borders, Language[] languages, Integer population) {
		super();
		this.name = name;
		this.capital = capital;
		this.borders = borders;
		this.languages = languages;
		this.population = population;
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

	public String[] getBorders() {
		return borders;
	}

	public void setBorders(String[] borders) {
		this.borders = borders;
	}

	public Language[] getLanguages() {
		return languages;
	}

	public void setLanguages(Language[] languages) {
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
		return "PaisRest [name=" + name + ", capital=" + capital + ", borders=" + Arrays.toString(borders)
				+ ", languages=" + Arrays.toString(languages) + ", population=" + population + "]";
	}

}
