package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController (ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id")long id ,Model model){
        model.addAttribute("product",this.productService.getProduct(id));
        return "product/detail";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("product") Product product) {
        productService.Add(product);
        return "redirect:/detail";
    }
}
