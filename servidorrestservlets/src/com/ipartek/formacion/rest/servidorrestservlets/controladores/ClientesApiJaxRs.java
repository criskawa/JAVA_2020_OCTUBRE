package com.ipartek.formacion.rest.servidorrestservlets.controladores;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ipartek.formacion.rest.servidorrestservlets.entidades.Cliente;

@Path("/clientes/")
@Consumes("application/json")
@Produces("application/json")
public class ClientesApiJaxRs {
	private static TreeMap<Long, Cliente> clientes = new TreeMap<>();

	static {
		clientes.put(1L, new Cliente(1L, "Javier", "Lete"));
		clientes.put(2L, new Cliente(2L, "Pepe", "Pérez"));
		clientes.put(3L, new Cliente(3L, "Juan", "Gómez"));
	}

	@GET
	public Iterable<Cliente> getClientes() {
		return clientes.values();
	}

	@GET
	@Path("{id}")
	public Response getCliente(@PathParam("id") Long id) {
		Cliente cliente = clientes.get(id);
		
		if(cliente != null) {
			return Response.ok().entity(clientes.get(id)).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@POST
	public Response postCliente(Cliente cliente) throws URISyntaxException {
		cliente.setId(clientes.lastKey() + 1);

		clientes.put(cliente.getId(), cliente);
		
		return Response.created(new URI("/clientes/" + cliente.getId())).entity(cliente).build();
	}

	@PUT
	@Path("{id}")
	public Cliente putCliente(@PathParam("id") Long id, Cliente cliente) {
		clientes.put(id, cliente);
		
		return cliente;
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteCliente(@PathParam("id") Long id) {
		clientes.remove(id);
		
		return Response.noContent().build();
	}
}
