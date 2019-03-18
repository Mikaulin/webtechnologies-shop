package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.services.ProductService;

@Controller

public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController (ProductService productService) {

        this.productService = productService;
    }



    @GetMapping("/producto")
    public String producto(@RequestParam("id")int id,Model model){
        model.addAttribute("producto",this.productService.getProduct(id));
        return "producto";
    }






    @RequestMapping(value = "/product/create", method = RequestMethod.POST)
    public String productCreate(@ModelAttribute("product") Product product) {
        productService.Add(product);
        return "redirect:/product";
    }
}
