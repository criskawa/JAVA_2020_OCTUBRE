package com.ipartek.formacion.uf2218.crud.logicanegocio;

import com.ipartek.formacion.uf2218.crud.modelos.Genero;
import com.ipartek.formacion.uf2218.crud.modelos.Pelicula;

public interface PeliculasLogica {
	Iterable<Pelicula> listarPeliculas();
	Pelicula obtenerPorId(Long id);
	
	void anadirPelicula(Pelicula pelicula);
	void editarPelicula(Pelicula pelicula);
	void borrarPelicula(Long id);
	
	Iterable<Genero> obtenerGeneros();
	Genero obtenerGeneroPorId(Long id);
}
