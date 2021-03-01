package com.ipartek.formacion.spring.tiendaspa.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ipartek.formacion.spring.tiendaspa.entidades.Categoria;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "categorias", path = "categorias")
public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Long> {

}
