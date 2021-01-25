package com.ipartek.formacion.rest.servidorrestservlets.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Cliente {
	private Long id;
	private String nombre, apellidos;
}
