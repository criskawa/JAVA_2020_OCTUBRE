package com.ipartek.formacion.uf2218.crud.controladores;

import com.ipartek.formacion.uf2218.crud.logicanegocio.PeliculasLogica;
import com.ipartek.formacion.uf2218.crud.logicanegocio.PeliculasLogicaImpl;
import com.ipartek.formacion.uf2218.crud.logicanegocio.UsuariosLogica;
import com.ipartek.formacion.uf2218.crud.logicanegocio.UsuariosLogicaImpl;

public class Configuracion {
	public static UsuariosLogica usuarioLogica = UsuariosLogicaImpl.getInstancia();
	public static PeliculasLogica peliculaLogica = PeliculasLogicaImpl.getInstancia();
}
