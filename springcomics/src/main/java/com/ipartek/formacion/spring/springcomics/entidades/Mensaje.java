package com.ipartek.formacion.spring.springcomics.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mensaje {
	private String nivel, texto;
}
