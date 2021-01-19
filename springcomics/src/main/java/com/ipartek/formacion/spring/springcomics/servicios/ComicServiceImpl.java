package com.ipartek.formacion.spring.springcomics.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.springcomics.entidades.Comic;
import com.ipartek.formacion.spring.springcomics.repositorios.Dao;

import lombok.extern.java.Log;

@Log
@Service
public class ComicServiceImpl implements ComicService {

	@Autowired
	private Dao<Comic> dao;
	
	@Override
	public void guardar(Comic comic) {
		log.info("Antes de guardar un comic");
		dao.editar(comic);
		log.info("Después de guardar un comic");
	}

	@Override
	public Iterable<Comic> listar() {
		return dao.obtenerTodos();
	}

	@Override
	public Comic obtenerPorId(Long id) {
		return dao.obtenerPorId(id);
	}

	@Override
	public void agregar(Comic comic) {
		dao.insertar(comic);
	}

	@Override
	public void borrar(Long id) {
		dao.borrar(id);
	}
}
