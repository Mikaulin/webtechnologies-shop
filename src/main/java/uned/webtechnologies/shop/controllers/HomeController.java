
package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.services.ProductService;
import uned.webtechnologies.shop.services.PurchaseLineService;

@Controller
@RequestMapping
public class HomeController {

    private ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;

    }
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView result = new ModelAndView("index");
        result.addObject("featuredProducts", this.productService.getFeaturedProducts());
        return result;
    }

    @GetMapping("/servicios")
    public String services(Model model) {
        return "home/services";
    }

    @GetMapping("/memoria")
    public String memory(Model model) {
        return "home/memoria";
    }

    @GetMapping("/manual")
    public String manual(Model model) {
        return "home/manual";
    }

}