package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.services.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController (ProductService productService) {

        this.productService = productService;
    }

    @GetMapping("/product")
    public String productList(Model model) {
        model.addAttribute("productList", this.productService.getProducts());
        return "product";
    }

    @RequestMapping("/product/delete/{id}")
    public String productDelete(@PathVariable("id") Long id, Model model) {
        productService.productDelete(id);
        return "redirect:/product";
    }

    @RequestMapping("/product/form")
    public String productForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/productform";
    }

    @RequestMapping(value = "/product/create", method = RequestMethod.POST)
    public String productCreate(@ModelAttribute("product") Product product) {
        productService.productAdd(product);
        return "redirect:/product";
    }
}
