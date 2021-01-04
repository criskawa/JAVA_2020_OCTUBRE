package com.ipartek.formacion.uf2218.crud.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.uf2218.crud.accesodatos.AccesoDatosException;

@WebServlet("/admin/borrar")
public class PeliculaBorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		
		Long id = Long.parseLong(sId);
		
		String alertaMensaje, alertaTipo;
		
		try {
			Configuracion.peliculaLogica.borrarPelicula(id);
			
			alertaMensaje = "Registro " + id + " borrado correctamente";
			alertaTipo = "success";
		} catch (AccesoDatosException e) {
			alertaMensaje = "El registro a borrar no existe";
			alertaTipo = "warning";
		}
		
		HttpSession session = request.getSession();
		
		session.setAttribute("alertatipo", alertaTipo);
		session.setAttribute("alertamensaje", alertaMensaje);
		
		response.sendRedirect(request.getContextPath() + "/admin/listado");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
