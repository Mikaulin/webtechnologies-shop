
package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.services.ProductService;
import uned.webtechnologies.shop.services.RatingService;

@Controller
@RequestMapping
public class HomeController {

    private ProductService productService;
    private RatingService ratingService;

    @Autowired
    public HomeController(ProductService productService,RatingService ratingService) {

        this.productService = productService;
        this.ratingService=ratingService;
    }
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView result = new ModelAndView("index");
        result.addObject("featuredProducts", this.productService.getFeaturedProducts());
        result.addObject("rating",this.ratingService);
        return result;
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