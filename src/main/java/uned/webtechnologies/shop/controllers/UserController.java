package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.services.SecurityService;
import uned.webtechnologies.shop.services.UserService;
import uned.webtechnologies.shop.validator.UserValidator;

/**
 * Controlador para operaciones de usuario.
 */
@Controller
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    /**
     * Método para registrarse en la aplicación
     *
     * @param model Modelo que se asigna a la vista, User.
     * @return Devuelve la vista de registro.
     */
    @GetMapping("/registro")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "auth/register";
    }

    /**
     * Método POST del registro de usuario.
     *
     * @param userForm Modelo User con los datos que vienen de la vista.
     * @param bindingResult Interfaz de validación para obtener si hay errores.
     * @return Redirecciona a la home de la web.
     */
    @PostMapping("/registro")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "auth/register";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/";
    }

    /**
     * Método para conectarse a la web.
     *
     * @param model Modelo que se asigna a la vista.
     * @param error String con algún mensaje de error.
     * @param logout String para saber si hay que desconectar.
     * @return La vista de login.
     */
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Tus datos son incorrectos.");

        if (logout != null)
            model.addAttribute("message", "Te has desconectado correctamente.");

        return "auth/login";
    }

    /**
     * Método para que el usuario conectado pueda darse de baja.
     *
     * @param activeUser El usuario conectado.
     * @return Devuelve los datos del usuario para mostrarlos por pantalla.
     */
    @GetMapping("/baja")
    public ModelAndView bajaUser(@AuthenticationPrincipal UserDetails activeUser){
        User user = userService.findByUsername(activeUser.getUsername());
        ModelAndView result = new ModelAndView("user/baja");
        result.addObject("bajaUser", user);
        return result;
    }

    /**
     * Método POST para que el usuario conectado pueda darse de baja y le desconecte.
     * @param activeUser Usuario autenticado en el sistema
     * @return Cadena de texto que redirecciona a "/logout"
     */
    @PostMapping("/baja")
    public String deleteUser(@AuthenticationPrincipal UserDetails activeUser){
        User user = this.userService.findByUsername(activeUser.getUsername());
        if(user != null) {
            this.userService.delete(user);
        }
        return "redirect:/logout";
    }

    /**
     * Método para devolver la vista de bienvenida.
     *
     * @param model Modelo actual de la vista.
     * @return La vista de bienvenida.
     */
    @GetMapping({ "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }

    /**
     * Método para obtener los detalles de un usuario.
     *
     * @param username String con el nombre de usuario.
     * @return Devuelve a la vista el modelo User.
     */
    @GetMapping("/detalles/{username}")
    public ModelAndView detailUser(@PathVariable("username")String username){
        ModelAndView result = new ModelAndView("user/detail");
        result.addObject("detailUser", this.userService.findByUsername(username));
        return result;
    }

}