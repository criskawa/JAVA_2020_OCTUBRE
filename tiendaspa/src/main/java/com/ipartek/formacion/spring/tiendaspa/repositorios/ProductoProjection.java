package com.ipartek.formacion.spring.tiendaspa.repositorios;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.ipartek.formacion.spring.tiendaspa.entidades.Categoria;
import com.ipartek.formacion.spring.tiendaspa.entidades.Producto;

@Projection(name = "producto", types = { Producto.class })
public interface ProductoProjection {
	Long getId();
	String getNombre();
	String getDescripcion();
	LocalDate getFechaCaducidad();
	BigDecimal getPrecio();
	Categoria getCategoria();
	@Value("#{target.getCategoria().getNombre()}")
	String getNombreCategoria();
}
