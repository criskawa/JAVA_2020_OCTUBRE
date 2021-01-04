package com.ipartek.formacion.uf2218.crud.logicanegocio;

import java.util.logging.Logger;

import com.ipartek.formacion.uf2218.crud.accesodatos.Dao;
import com.ipartek.formacion.uf2218.crud.accesodatos.GenerosDaoTreeMap;
import com.ipartek.formacion.uf2218.crud.accesodatos.PeliculasDaoMySql;
import com.ipartek.formacion.uf2218.crud.modelos.Genero;
import com.ipartek.formacion.uf2218.crud.modelos.Pelicula;

public class PeliculasLogicaImpl implements PeliculasLogica {
	private static final Logger LOGGER = Logger.getLogger(PeliculasLogicaImpl.class.getName());
	
	private static Dao<Pelicula> dao = PeliculasDaoMySql.getInstancia();
	private static Dao<Genero> daoGeneros = GenerosDaoTreeMap.getInstancia();
	
	private PeliculasLogicaImpl() {}
	
	private static final PeliculasLogicaImpl INSTANCIA = new PeliculasLogicaImpl();
	
	public static PeliculasLogicaImpl getInstancia() {
		return INSTANCIA;
	}
	
	@Override
	public Iterable<Pelicula> listarPeliculas() {
		return dao.obtenerTodos();
	}

	@Override
	public void anadirPelicula(Pelicula pelicula) {
		dao.insertar(pelicula);
	}

	@Override
	public void editarPelicula(Pelicula pelicula) {
		dao.modificar(pelicula);
	}

	@Override
	public void borrarPelicula(Long id) {
		dao.borrar(id);
	}

	@Override
	public Pelicula obtenerPorId(Long id) {
		return dao.obtenerPorId(id);
	}

	@Override
	public Iterable<Genero> obtenerGeneros() {
		return daoGeneros.obtenerTodos();
	}

	@Override
	public Genero obtenerGeneroPorId(Long id) {
		LOGGER.info(id.toString());
		return daoGeneros.obtenerPorId(id);
	}

}
