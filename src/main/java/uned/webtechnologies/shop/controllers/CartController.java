package uned.webtechnologies.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/carrito")
public class CartController {

    @GetMapping()
    public ModelAndView list() {
        ModelAndView result = new ModelAndView("cart/list");
        return result;
    }
}
