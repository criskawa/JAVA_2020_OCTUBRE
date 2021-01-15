package com.ipartek.formacion.spring.springcomics.entidades;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaLanzamiento;
	@Min(1)
	private Integer	numeroPaginas;
	private String resumen;
	private String urlImagen;
}
