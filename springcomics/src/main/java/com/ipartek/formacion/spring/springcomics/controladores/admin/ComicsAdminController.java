package com.ipartek.formacion.spring.springcomics.controladores.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ComicsAdminController {
	@GetMapping //("/comics")
	public String comics() {
		return "admin/comics";
	}	
}
