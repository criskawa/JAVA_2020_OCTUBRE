package com.ipartek.formacion.spring.springcomics.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.formacion.spring.springcomics.entidades.Comic;
import com.ipartek.formacion.spring.springcomics.repositorios.Dao;

@Controller
public class ComicsController {
	@Autowired
	private Dao<Comic> dao;
	
	@GetMapping("/")
	public String comics(Model modelo) {
		modelo.addAttribute("comics", dao.obtenerTodos());
		return "comics";
	}

}
