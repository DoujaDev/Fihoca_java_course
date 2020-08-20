package com.example.demo;

public class Country {
	
	private String country;
	private String capital;
	private int bordersNum;
	private int languagesNum;
	private int population;
	
	public Country() {
		
	}

	public Country(String country, String capital, int bordersNum, int languagesNum, int population) {
		super();
		this.country = country;
		this.capital = capital;
		this.bordersNum = bordersNum;
		this.languagesNum = languagesNum;
		this.population = population;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getBordersNum() {
		return bordersNum;
	}

	public void setBordersNum(int bordersNum) {
		this.bordersNum = bordersNum;
	}

	public int getLanguagesNum() {
		return languagesNum;
	}

	public void setLanguagesNum(int languagesNum) {
		this.languagesNum = languagesNum;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "ServerAsClient [country=" + country + ", capital=" + capital + ", bordersNum=" + bordersNum
				+ ", languagesNum=" + languagesNum + ", population=" + population + "]";
	}
	
	

}
