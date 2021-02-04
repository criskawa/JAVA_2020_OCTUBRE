package com.ipartek.formacion.spring.springrest.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ipartek.formacion.spring.springrest.entidades.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {
	List<Cliente> findByApellidos(String apellidos);
	
	@Query("select c.id from Cliente c where c.nombre = :nombre and c.apellidos = :apellidos")
	Long findIdByNombreApellidos(String nombre, String apellidos);
}
