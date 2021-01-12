package com.ipartek.formacion.spring.springcomics.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.springcomics.entidades.Comic;

@Repository
public class ComicDaoMySql implements Dao<Comic> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Iterable<Comic> obtenerTodos() {
		return jdbcTemplate.query("SELECT * FROM comics", new BeanPropertyRowMapper<Comic>(Comic.class));

//		return jdbcTemplate.query("SELECT * FROM comics",
//				(rs, rowNum) -> new Comic(rs.getLong("id"), rs.getString("titulo"), (LocalDate)rs.getObject("fecha_lanzamiento"),
//						rs.getInt("numero_paginas"), rs.getString("url_imagen"), rs.getString("resumen")));
	}
}
