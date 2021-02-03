package com.ipartek.formacion.spring.springdatajpa.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.springdatajpa.entidades.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	@Query("FROM Categoria c JOIN FETCH c.productos WHERE c.id = :id")
	Categoria findByIdWithProducts(Long id);
}
