package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.services.SecurityService;
import uned.webtechnologies.shop.services.UserService;
import uned.webtechnologies.shop.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "auth/register";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "auth/register";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Tus datos son incorrectos.");

        if (logout != null)
            model.addAttribute("message", "Te has desconectado correctamente.");

        return "auth/login";
    }

    @GetMapping("/usuarios")
    public ModelAndView listUser() {
        ModelAndView result = new ModelAndView("user/list");
        result.addObject("users", this.userService.getUser());
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
        return "redirect:/user/usuarios";
    }

    @GetMapping("/detail/{username}")
    public ModelAndView detailUser(@PathVariable("username")String username){
        ModelAndView result = new ModelAndView("user/detail");
        result.addObject("detailUser", this.userService.findByUsername(username));
        return result;
    }

    @GetMapping("/baja/{username}")
    public ModelAndView bajaUser(@PathVariable("username")String username){
        ModelAndView result = new ModelAndView("user/baja");
        result.addObject("bajaUser", this.userService.findByUsername(username));
        return result;
    }

    @GetMapping({ "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }

}