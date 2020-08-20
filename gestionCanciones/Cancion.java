package com.fomentoformacion.gestionproductos.model;

import java.util.ArrayList;
import java.util.List;

public class Cancion {
	
	private Integer codigo;
	private String titulo;
	private String artista;
	private int anyo;
	private Estilo estilo;
	private boolean explicito;
	private List<String> comentarios = new ArrayList<>();
	
	public Cancion() {
		
	}
	
	public void addComentario(String comentario) {
		comentarios.add(comentario);
	}

	public Cancion(Integer codigo, String titulo, Estilo estilo) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.estilo = estilo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public boolean isExplicito() {
		return explicito;
	}

	public void setExplicito(boolean explicito) {
		this.explicito = explicito;
	}

	public List<String> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<String> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Cancion [codigo=" + codigo + ", titulo=" + titulo + ", artista=" + artista + ", anyo=" + anyo
				+ ", estilo=" + estilo + ", explicito=" + explicito + ", comentarios=" + comentarios + "]";
	}

}
