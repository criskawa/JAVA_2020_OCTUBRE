package com.ipartek.formacion.uf2218.crud.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.crud.modelos.Pelicula;

@WebServlet("/admin/pelicula")
/**
 * Servlet para el mantenimiento de una película, facilitando las operaciones CRUD básicas
 */
public class PeliculaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Visualización de la pantalla de detalles de la película
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		
		Pelicula pelicula = null;
		
		if(sId != null) {
			Long id = Long.parseLong(sId);
		
			pelicula = Configuracion.peliculaLogica.obtenerPorId(id);
		}
		
		Mapeadores.peliculaAFormulario(request, response, pelicula);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}	
	

}
