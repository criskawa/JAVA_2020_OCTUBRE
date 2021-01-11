package com.ipartek.formacion.spring.springmvcbasico;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SaludoController {
	
	@GetMapping("/")
	public String saludar(
			@RequestParam("nombre") String nombre, 
			Model modelo) {
		
		modelo.addAttribute("nombre", nombre + " amigo2");
		
		return "saludo";
	}
}
