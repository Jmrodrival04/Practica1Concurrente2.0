package io.dreamteam.practica1_concurrente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminPage() {
        return "admin"; // Devuelve un archivo HTML que mostraría la página de administración
    }
}