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

@Controller
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    @GetMapping("/registro")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "auth/register";
    }

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

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Tus datos son incorrectos.");

        if (logout != null)
            model.addAttribute("message", "Te has desconectado correctamente.");

        return "auth/login";
    }

    @GetMapping("/baja")
    public ModelAndView bajaUser(@AuthenticationPrincipal UserDetails activeUser){
        User user = userService.findByUsername(activeUser.getUsername());
        ModelAndView result = new ModelAndView("user/baja");
        result.addObject("bajaUser", user);
        return result;
    }

    @PostMapping("/baja")
    public String deleteUser(@AuthenticationPrincipal UserDetails activeUser){
        User user = this.userService.findByUsername(activeUser.getUsername());
        if(user != null) {
            this.userService.delete(user);
        }
        return "redirect:/logout";
    }

    @GetMapping({ "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }

    @GetMapping("/detalles/{username}")
    public ModelAndView detailUser(@PathVariable("username")String username){
        ModelAndView result = new ModelAndView("user/detail");
        result.addObject("detailUser", this.userService.findByUsername(username));
        return result;
    }

}