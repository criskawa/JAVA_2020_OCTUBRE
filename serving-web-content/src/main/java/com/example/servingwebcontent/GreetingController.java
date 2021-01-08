package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

        @GetMapping("/saludar")
        public String greeting(@RequestParam(name="nombre", required=false, defaultValue="Mundo") String nombre, Model modelo) {
                modelo.addAttribute("nombre", nombre + " pruebaasdfads");
                return "saludo";
        }

}

