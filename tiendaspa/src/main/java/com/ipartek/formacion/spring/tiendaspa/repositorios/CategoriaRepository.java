package com.ipartek.formacion.spring.tiendaspa.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.tiendaspa.entidades.Categoria;

@RepositoryRestResource(collectionResourceRel = "categorias", path = "categorias", excerptProjection = CategoriaProjection.class)
public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Long> {

}
