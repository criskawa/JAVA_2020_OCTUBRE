package com.ipartek.formacion.spring.tiendaspa.entidades;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "categoria", types = { Categoria.class })
public interface CategoriaProjection {
	Long getId();
	String getNombre();
	String getDescripcion();
}
