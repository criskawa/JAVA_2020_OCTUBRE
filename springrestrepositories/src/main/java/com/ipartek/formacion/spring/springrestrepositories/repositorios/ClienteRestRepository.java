package com.ipartek.formacion.spring.springrestrepositories.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.springrestrepositories.entidades.Cliente;

@RepositoryRestResource(collectionResourceRel = "clientes", path = "clientes")
public interface ClienteRestRepository extends PagingAndSortingRepository<Cliente, Long>{

}
