package com.henrry.saludo.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SaludoController {


    @GetMapping("/saludo")
    public String obtenerSaludo() {
        return "¡Hola, API RESTful!";
    }


}
