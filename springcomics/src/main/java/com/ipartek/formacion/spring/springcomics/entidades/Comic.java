package com.ipartek.formacion.spring.springcomics.entidades;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Comic {
	private Long id;
	@NotBlank
	@Size(min = 3, max = 150)
	private String titulo;
	@PastOrPresent
	private LocalDate fechaLanzamiento;
	@Min(1)
	private Integer	numeroPaginas;
	private String resumen;
	private String urlImagen;
}
