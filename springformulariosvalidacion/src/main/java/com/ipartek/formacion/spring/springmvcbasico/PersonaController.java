package com.ipartek.formacion.spring.springmvcbasico;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ipartek.formacion.spring.springmvcbasico.modelos.PersonaForm;

@Controller
public class PersonaController implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/resultados").setViewName("resultados");
	}

	/*
	 * @GetMapping("/resultados") public String mostrarResultados() { return
	 * "resultados"; }
	 */

	@GetMapping("/")
	public String mostrarFormulario(PersonaForm personaForm) {
		return "formulario";
	}

	@PostMapping("/")
	public String obtenerInformacionPersona(@Valid PersonaForm personaForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "formulario";
		}

		return "redirect:/resultados";
	}
}
