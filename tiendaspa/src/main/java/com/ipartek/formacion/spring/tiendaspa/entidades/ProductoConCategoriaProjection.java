package com.ipartek.formacion.spring.tiendaspa.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "productoConCategoria", types = { Producto.class })
public interface ProductoConCategoriaProjection {
	Long getId();
	String getNombre();
	String getDescripcion();
	LocalDate getFechaCaducidad();
	BigDecimal getPrecio();
	Categoria getCategoria();
	@Value("#{target.getCategoria().getNombre()}")
	String getNombreCategoria();
}
