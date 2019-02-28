package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uned.webtechnologies.shop.services.UserService;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String userList(Model model) {
        model.addAttribute("userList", this.userService.getUsers());
        return "user/list";
    }
}
