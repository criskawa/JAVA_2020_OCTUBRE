package com.ipartek.formacion.spring.springcomics.controladores.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.springcomics.entidades.Comic;
import com.ipartek.formacion.spring.springcomics.repositorios.Dao;

@Controller
@RequestMapping("/admin")
public class ComicsAdminController {
	@Autowired
	private Dao<Comic> dao;

	@GetMapping // ("/comics")
	public String comics(Model modelo) {
		modelo.addAttribute("comics", dao.obtenerTodos());
		return "admin/comics";
	}

	@GetMapping("/{id}")
	public String comic(@PathVariable Long id, Model modelo) {
		Comic comic;
		if (id != 0) {
			comic = dao.obtenerPorId(id);
		} else {
			comic = new Comic();
		}

		modelo.addAttribute("comic", comic);

		return "admin/comic";
	}
	
	@PostMapping
	public String comicPost(Model modelo) {
		Comic comic = new Comic();

		modelo.addAttribute("comic", comic);

		return "admin/comic";
	}
	
}
