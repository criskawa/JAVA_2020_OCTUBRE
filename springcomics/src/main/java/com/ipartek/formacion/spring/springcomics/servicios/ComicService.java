package com.ipartek.formacion.spring.springcomics.servicios;

import com.ipartek.formacion.spring.springcomics.entidades.Comic;

public interface ComicService {
	Iterable<Comic> listar();
	Comic obtenerPorId(Long id);
	void agregar(Comic comic);
	void guardar(Comic comic);
	void borrar(Long id);
}
