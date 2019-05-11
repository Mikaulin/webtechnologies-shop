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
    /**
     * Página de error personalizada para accesos denegados.
     *
     * @return Devolverá la vista de la página para accesos denegados.
     */
    @GetMapping("/acceso-denegado")
    public String accessDenied() {
        return "error/accessDenied";
    }
}
