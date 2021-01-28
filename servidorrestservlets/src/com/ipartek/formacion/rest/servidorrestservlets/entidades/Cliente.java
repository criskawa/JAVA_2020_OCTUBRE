package com.ipartek.formacion.rest.servidorrestservlets.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Cliente {
	private Long id;
	private String nombre, apellidos;
}
