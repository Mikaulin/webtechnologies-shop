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

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/admin/usuarios")
public class UserAdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;

    @GetMapping("/alta")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "auth/register";
    }

    @PostMapping("/alta")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "auth/register";
        }
        userService.save(userForm);
        return "redirect:/admin/usuarios/listado";
    }

    @GetMapping("/listado")
    public ModelAndView listUser() {
        ModelAndView result = new ModelAndView("user/list");
        result.addObject("users", this.userService.getUsers());
        return result;
    }

    @GetMapping("/editar/{username}")
    public ModelAndView editUser(@PathVariable("username")String username){
        ModelAndView result = new ModelAndView("user/edit");
        result.addObject("editUser", this.userService.findByUsername(username));
        return result;
    }

    @RequestMapping(value = "/editar/{username}", method = RequestMethod.POST)
    public String edit(@PathVariable("username") String username, @ModelAttribute("user") User user) {
        userService.update(username, user);
        return "redirect:/admin/usuarios/listado";
    }

    @GetMapping("/detalles/{username}")
    public ModelAndView detailUser(@PathVariable("username")String username){
        ModelAndView result = new ModelAndView("user/detail");
        result.addObject("detailUser", this.userService.findByUsername(username));
        return result;
    }

    @GetMapping("/baja/{username}")
    public ModelAndView bajaUser(@PathVariable("username")String username){
        ModelAndView result = new ModelAndView("user/adminBaja");
        result.addObject("user", this.userService.findByUsername(username));
        return result;
    }

    @PostMapping("/baja/{username}")
    public String deleteUser(@PathVariable("username")String username){
        User user = this.userService.findByUsername(username);
        if(user != null) {
            this.userService.delete(user);
        }
        return "redirect:/admin/usuarios/listado";
    }

}
