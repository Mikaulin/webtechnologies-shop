
package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uned.webtechnologies.shop.services.ProductService;

@Controller
@RequestMapping
public class HomeController {

    private ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {

        this.productService = productService;
    }
    @GetMapping("/")
    public String index(Model model) {
       model.addAttribute("productList", this.productService.getFeaturedProducts());
        return "index";
    }

    @GetMapping("/ofertas")
    public String offers(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "home/offers";
    }

    @GetMapping("/servicios")
    public String services() {
        return "home/services";
    }
}