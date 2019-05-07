package uned.webtechnologies.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para gestionar las paginas de error de la vista-modelo
 */
@Controller
@RequestMapping("/error")
public class ErrorController {
    @GetMapping("/acceso-denegado")
    public String accessDenied() {
        return "error/accessDenied";
    }
}
