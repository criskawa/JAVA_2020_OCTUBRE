package com.ipartek.formacion.spring.tiendaspa.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.tiendaspa.entidades.Producto;

// excerptProjection = ProductoProjection.class
// Activa la visualización de los elementos de tipo producto a través de la proyección pero sólo en las colecciones no individualmente
// Para la visualización de un elemento individual necesitamos ADEMÁS del excerpt, añadir ?projection=productoProjection a la petición individual
@RepositoryRestResource(collectionResourceRel = "productos", path = "productos", excerptProjection = ProductoProjection.class)
public interface ProductoRepository extends PagingAndSortingRepository<Producto, Long>{

}
