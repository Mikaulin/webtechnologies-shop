package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.services.UserService;
import uned.webtechnologies.shop.validator.UserValidator;

/** Controlador para gestionar los Usuarios de la vista-modelo,solo accesible para usuarios con el ROLE de ADMINISTRADOR
 * <P>Responde a las URLs "/admin/usuarios(/..)*"</P>
 *
 */

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/admin/usuarios")
public class UserAdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;

    /**
     * Método GET para que el administrador de de alta un nuevo cliente.
     *
     * @param model El modelo de la entidad User.
     * @return La vista de registro de usuario.
     */
    @GetMapping("/alta")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "auth/register";
    }

    /**
     * Método POST para que el administrador de de alta un nuevo cliente.
     *
     * @param userForm Modelo User con los datos del nuevo usuario.
     * @param bindingResult Interfaz de validación para obtener si hay errores.
     * @return Redirecciona al listado de usuarios.
     */
    @PostMapping("/alta")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "auth/register";
        }
        userService.save(userForm);
        return "redirect:/admin/usuarios/listado";
    }

    /**
     * Listado de usuarios registrados.
     *
     * @return Devuelve a la vista el listado de usuarios.
     */
    @GetMapping("/listado")
    public ModelAndView listUser() {
        ModelAndView result = new ModelAndView("user/list");
        result.addObject("users", this.userService.getUsers());
        return result;
    }

    /**
     * Método para editar los datos de un usuario.
     *
     * @param username Un string con el username del usuario.
     * @return Devuelve a la vista los datos del usuario.
     */
    @GetMapping("/editar/{username}")
    public ModelAndView editUser(@PathVariable("username")String username){
        ModelAndView result = new ModelAndView("user/edit");
        result.addObject("editUser", this.userService.findByUsername(username));
        return result;
    }

    /**
     * Método POST para modificar los datos de un usuario ya existente.
     *
     * @param username Un string con el username del usuario.
     * @param user La entidad User.
     * @return Redirige a la pantalla del listado.
     */
    @RequestMapping(value = "/editar/{username}", method = RequestMethod.POST)
    public String edit(@PathVariable("username") String username, @ModelAttribute("user") User user) {
        userService.update(username, user);
        return "redirect:/admin/usuarios/listado";
    }

    /**
     * Obtener los detalles de un usuario.
     *
     * @param username Un string con el username del usuario.
     * @return Devuelve a la vista los datos de un usuario.
     */
    @GetMapping("/detalles/{username}")
    public ModelAndView detailUser(@PathVariable("username")String username){
        ModelAndView result = new ModelAndView("user/detail");
        result.addObject("detailUser", this.userService.findByUsername(username));
        return result;
    }

    /**
     * Método para ir a la pantalla previa a la baja de un cliente.
     *
     * @param username Un string con el username del usuario.
     * @return Devuelve los datos del usuario a la vista.
     */
    @GetMapping("/baja/{username}")
    public ModelAndView bajaUser(@PathVariable("username")String username){
        ModelAndView result = new ModelAndView("user/adminBaja");
        result.addObject("user", this.userService.findByUsername(username));
        return result;
    }

    /**
     * Método POST para dar de baja al usuario.
     *
     * @param username Un string con el username del usuario.
     * @return Redirige al listado de usuarios.
     */
    @PostMapping("/baja/{username}")
    public String deleteUser(@PathVariable("username")String username){
        User user = this.userService.findByUsername(username);
        if(user != null) {
            this.userService.delete(user);
        }
        return "redirect:/admin/usuarios/listado";
    }

}
