package com.empresaa.paises.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestPais {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("capital")
	private String capital;
	
	@JsonProperty("borders")
	private List<String> borders;
	
	@JsonProperty("languages")
	private List<Map<String,String>> languages;
	
	@JsonProperty("population")
	private Integer population;
	
	public RestPais () {
		
	}

	public RestPais(String name, String capital, List<String> borders, List<Map<String, String>> languages,
			Integer population) {
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

	public List<String> getBorders() {
		return borders;
	}

	public void setBorders(List<String> borders) {
		this.borders = borders;
	}

	public List<Map<String, String>> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Map<String, String>> languages) {
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
		return "RestPais [name=" + name + ", capital=" + capital + ", borders=" + borders + ", languages=" + languages
				+ ", population=" + population + "]";
	}
	
	
}
