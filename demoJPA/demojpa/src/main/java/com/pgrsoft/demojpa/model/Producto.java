package com.pgrsoft.demojpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTOS")
public class Producto {

	@Id
	@Column(name="CODIGO")
	private Long code;
	
	@Column(name="NOMBRE")
	private String name;
	
	@Column(name="PRECIO")
	private double price;
	
	public Producto() {
		
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Producto [code=" + code + ", name=" + name + ", price=" + price + "]";
	}
	
}
