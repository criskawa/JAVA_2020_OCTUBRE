package com.ipartek.formacion.spring.springcomics.repositorios;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.springcomics.entidades.Comic;

@Repository
public class ComicDaoMySql implements Dao<Comic> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public Iterable<Comic> obtenerTodos() {
		return jdbcTemplate.query("SELECT * FROM comics", new BeanPropertyRowMapper<Comic>(Comic.class));

//		return jdbcTemplate.query("SELECT * FROM comics",
//				(rs, rowNum) -> new Comic(rs.getLong("id"), rs.getString("titulo"), (LocalDate)rs.getObject("fecha_lanzamiento"),
//						rs.getInt("numero_paginas"), rs.getString("url_imagen"), rs.getString("resumen")));
	}

	@Override
	public Comic obtenerPorId(Long id) {
		return jdbcTemplate.queryForObject(
				"SELECT * FROM comics WHERE id = ?", 
				new BeanPropertyRowMapper<Comic>(Comic.class), 
				new Object[] { id });
	}

	@Override
	public Comic insertar(Comic comic) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("comics").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<>(1);
	    
		parameters.put("titulo", comic.getTitulo());
		parameters.put("resumen", comic.getResumen());
		parameters.put("numero_paginas", comic.getNumeroPaginas());
		parameters.put("url_imagen", comic.getUrlImagen());
		parameters.put("fecha_lanzamiento", comic.getFechaLanzamiento());
	    
		Long newId = ((BigInteger)simpleJdbcInsert.executeAndReturnKey(parameters)).longValue();
	    comic.setId(newId);
	    
	    return comic;
	}

	@Override
	public Comic editar(Comic comic) {
		jdbcTemplate.update("UPDATE comics SET titulo = ?, resumen = ?, numero_paginas = ?, url_imagen = ?, fecha_lanzamiento = ? WHERE id = ?",
				new Object[] { comic.getTitulo(), comic.getResumen(), comic.getNumeroPaginas(), comic.getUrlImagen(), comic.getFechaLanzamiento(), comic.getId()});
		return comic;
	}

	@Override
	public void borrar(Long id) {
		jdbcTemplate.update("DELETE FROM comics WHERE id = ?", new Object[] { id });
	}
	
	
}
