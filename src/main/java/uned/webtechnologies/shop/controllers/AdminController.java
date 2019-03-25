package uned.webtechnologies.shop.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping()
    public String index() {
        return "admin/index";
    }
}
