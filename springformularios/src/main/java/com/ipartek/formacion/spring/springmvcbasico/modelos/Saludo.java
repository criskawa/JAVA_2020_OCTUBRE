package com.ipartek.formacion.spring.springmvcbasico.modelos;

public class Saludo {
	private Long id;
	
	private String contenido;
	
	public Saludo() {
		super();
	}

	public Saludo(Long id, String contenido) {
		super();
		this.id = id;
		this.contenido = contenido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
}
