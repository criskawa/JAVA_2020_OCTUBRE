package com.ipartek.formacion.spring.tiendaspa.repositorios;

import org.springframework.data.rest.core.config.Projection;

import com.ipartek.formacion.spring.tiendaspa.entidades.Categoria;

@Projection(name = "categoria", types = { Categoria.class })
public interface CategoriaProjection {
	Long getId();
	String getNombre();
	String getDescripcion();
}
