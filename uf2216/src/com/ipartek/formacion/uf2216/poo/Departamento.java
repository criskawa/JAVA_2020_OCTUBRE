package com.ipartek.formacion.uf2216.poo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nombre;
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	
	public Departamento(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public void contratar(Usuario usuario) {
		if(usuario == null) {
			throw new PooException("No se admite contratar usuarios nulos");
		}
		
		usuarios.add(usuario);

		// TODO validar si el usuario ya está metido
	}
	
	public List<Usuario> getUsuarios() {
		return Collections.unmodifiableList(usuarios);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
