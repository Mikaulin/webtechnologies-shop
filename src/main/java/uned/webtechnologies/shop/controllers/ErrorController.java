package uned.webtechnologies.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para gestionar las paginas de error
 */
@Controller
@RequestMapping("/error")
public class ErrorController {
    /**Método que respnde al error-rul get ("/error/acceso-denegado")
     * @return Cadena c
     */
    @GetMapping("/acceso-denegado")
    public String accessDenied() {
        return "error/accessDenied";
    }
}
