package com.ipartek.formacion.rest.servidorrestservlets.controladores;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.formacion.rest.servidorrestservlets.entidades.Cliente;

@WebServlet({"/api/clientes", "/api/clientes/*"})
public class ClientesApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static TreeMap<Long, Cliente> clientes = new TreeMap<>();
	
	static {
		clientes.put(1L, new Cliente(1L, "Javier", "Lete"));
		clientes.put(2L, new Cliente(2L, "Pepe", "Pérez"));
		clientes.put(3L, new Cliente(3L, "Juan", "Gómez"));
	}
	
	private static Gson gson = new Gson();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		Long id = obtenerId(request);
		
		if(id == null) {
			response.getWriter().write(gson.toJson(clientes.values()));
		} else {
			response.getWriter().write(gson.toJson(clientes.get(id)));
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		Cliente cliente = gson.fromJson(request.getReader(), Cliente.class);
		
		cliente.setId(clientes.lastKey() + 1);
		
		clientes.put(cliente.getId(), cliente);
		
		response.setStatus(HttpServletResponse.SC_CREATED);
		
		response.getWriter().write(gson.toJson(cliente));
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		Long id = obtenerId(request);
		
		Cliente cliente = gson.fromJson(request.getReader(), Cliente.class);
		
		clientes.put(id, cliente);
		
		response.getWriter().write(gson.toJson(cliente));
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = obtenerId(request);
		
		clientes.remove(id);
		
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}
	
	private Long obtenerId(HttpServletRequest request) {
		String sId = request.getPathInfo();
		
		Long id = null;
		
		if(sId != null && !"/".equals(sId)) {
			id = Long.parseLong(sId.substring(1));			
		}
		
		return id;
	}
}
