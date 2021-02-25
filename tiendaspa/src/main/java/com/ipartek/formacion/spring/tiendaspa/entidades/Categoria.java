package com.ipartek.formacion.spring.tiendaspa.entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="categorias")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Size(min=3, max = 30)
	private String nombre;
	
	@Size(max = 5000)
	@Column(columnDefinition = "TEXT")
	private String descripcion;
	
	@Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
	private boolean activado = true;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "categoria")
	private Set<Producto> productos;
}
