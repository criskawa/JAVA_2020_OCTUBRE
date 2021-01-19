package com.ipartek.formacion.spring.springcomics.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.formacion.spring.springcomics.servicios.ComicService;

@Controller
public class ComicsController {
	@Autowired
	private ComicService servicio;
	
	@GetMapping("/")
	public String comics(Model modelo) {
		modelo.addAttribute("comics", servicio.listar());
		return "comics";
	}

}
