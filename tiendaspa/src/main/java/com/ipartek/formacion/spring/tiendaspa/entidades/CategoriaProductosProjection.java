package com.ipartek.formacion.spring.tiendaspa.entidades;

import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "categoriaProductos", types = { Categoria.class })
public interface CategoriaProductosProjection {
	Long getId();
	String getNombre();
	String getDescripcion();
	Set<Producto> getProductos();
}
