package com.ipartek.formacion.spring.tiendaspa.repositorios;

import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

import com.ipartek.formacion.spring.tiendaspa.entidades.Categoria;
import com.ipartek.formacion.spring.tiendaspa.entidades.Producto;

@Projection(name = "categoriaProductos", types = { Categoria.class })
public interface CategoriaProductosProjection {
	Long getId();
	String getNombre();
	String getDescripcion();
	Set<Producto> getProductos();
}
