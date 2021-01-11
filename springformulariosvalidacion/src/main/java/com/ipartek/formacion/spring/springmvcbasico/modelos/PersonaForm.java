package com.ipartek.formacion.spring.springmvcbasico.modelos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonaForm {
	@NotNull
	@Size(min=2, max=30)
	private String nombre;
	
	@NotNull
	@Min(18)
	private Integer edad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "PersonaForm [nombre=" + nombre + ", edad=" + edad + "]";
	}
}
