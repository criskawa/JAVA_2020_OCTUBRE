package com.ipartek.formacion.spring.springdatajpa.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.springdatajpa.entidades.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
