package com.ipartek.formacion.spring.tiendaspa.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	@Size(min=3, max=100)
	private String nombre;
	
	@Size(max=5000)
	@Column(columnDefinition = "TEXT")
	private String descripcion;
	
	// TODO: Mirar validaciones de fechas con desplazamiento de año
	private LocalDate fechaCaducidad;
	
	@NotNull
	@DecimalMin("0")
	@Column(columnDefinition = "DECIMAL(20,2)")
	private BigDecimal precio;
	
	@ManyToOne
	private Categoria categoria;
}
