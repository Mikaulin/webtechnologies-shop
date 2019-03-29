package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.services.CategoryService;
import uned.webtechnologies.shop.services.ProductService;

@Controller
@RequestMapping("/categorias")
public class CategoryController {
    private CategoryService categoryService;
    private ProductService productService;

    @Autowired
    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping()
    public ModelAndView list() {
        ModelAndView result = new ModelAndView("category/list");
        result.addObject("categories", this.categoryService.getCategories());
        return result;
    }

    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable("id") long id) {
        ModelAndView result = new ModelAndView("category/detail");
        result.addObject("products", this.productService.getProductsByCategoryId(id));
        //TODO Las marcas, ya que se repite el HTML en varias ocasiones, lo suyo sería sacar esto a una vista parcial
        /// como las que tenemos en shared y así dividimos responsabilidades
        result.addObject("category", this.categoryService.getCategories());
        return result;
    }
}
