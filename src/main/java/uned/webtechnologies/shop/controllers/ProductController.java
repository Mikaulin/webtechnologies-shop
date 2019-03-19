package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.services.ProductService;

@Controller
@RequestMapping("/producto")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController (ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/detalle/{id}")
    public ModelAndView detail(@PathVariable("id")long id){
        ModelAndView result = new ModelAndView("product/detail");
        result.addObject("product", this.productService.getProduct(id));
        return result;
    }

    //TODO Esto de momento no se usa, terminar o eliminar
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String create(@ModelAttribute("product") Product product) {
        productService.add(product);
        return "redirect:/detail";
    }
}
