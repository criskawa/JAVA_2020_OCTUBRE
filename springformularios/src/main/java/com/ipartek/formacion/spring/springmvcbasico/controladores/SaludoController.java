package com.ipartek.formacion.spring.springmvcbasico.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ipartek.formacion.spring.springmvcbasico.modelos.Saludo;

@Controller
public class SaludoController {
	@GetMapping("/saludar")
	public String saludoForm(Saludo saludo) {
		//saludo.setId(0L);
		//saludo.setContenido("Contenido inicial");
		
		return "saludo";
	}
	
	@PostMapping("/saludar")
	public String saludoPost(Saludo saludo) {
		return "resultado";
	}
}
