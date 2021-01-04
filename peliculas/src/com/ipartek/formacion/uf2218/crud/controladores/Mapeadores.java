package com.ipartek.formacion.uf2218.crud.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.crud.modelos.Genero;
import com.ipartek.formacion.uf2218.crud.modelos.Pelicula;

class Mapeadores {
	static void peliculaAFormulario(HttpServletRequest request, HttpServletResponse response, Pelicula pelicula)
			throws ServletException, IOException {
		request.setAttribute("pelicula", pelicula);
		request.setAttribute("generos", Configuracion.peliculaLogica.obtenerGeneros());

		if (pelicula != null) {
			request.setAttribute("subgeneros", pelicula.getGenero().getSubGeneros());
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/vistas/admin/pelicula.jsp");
		requestDispatcher.forward(request, response);
	}

	static Pelicula formularioAPelicula(HttpServletRequest request) {
		String id = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String generoTexto = request.getParameter("genero");
		String subGeneroTexto = request.getParameter("subgenero");
		String fechaEstreno = request.getParameter("fecha-estreno");

		Long generoId = Long.parseLong(generoTexto);
		Genero genero = Configuracion.peliculaLogica.obtenerGeneroPorId(generoId);

		Genero subGenero = null;

		if (subGeneroTexto != null) {
			Long subGeneroId = Long.parseLong(subGeneroTexto);

			if (subGeneroId != 0) {
				subGenero = Configuracion.peliculaLogica.obtenerGeneroPorId(subGeneroId);
			}
		}

		Pelicula pelicula = new Pelicula(id, titulo, genero, subGenero, fechaEstreno);

		return pelicula;
	}
}
