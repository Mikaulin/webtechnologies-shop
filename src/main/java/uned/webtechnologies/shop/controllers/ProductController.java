package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.services.BrandService;
import uned.webtechnologies.shop.services.CategoryService;
import uned.webtechnologies.shop.services.ProductService;

@Controller
@RequestMapping("/producto")
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;
    private BrandService brandService;

    @Autowired
    public ProductController (ProductService productService,CategoryService categoryService,BrandService brandService) {
        this.productService = productService;
        this.categoryService=categoryService;
        this.brandService=brandService;
    }

    @GetMapping("/detalle/{id}")
    public ModelAndView detail(@PathVariable("id")long id){
        ModelAndView result = new ModelAndView("product/detail");
        result.addObject("product", this.productService.getProduct(id));
        return result;
    }

    @GetMapping ("/alta")
    public ModelAndView showForm(){
        ModelAndView result=new ModelAndView("product/productform");
        result.addObject("brands", this.brandService.getBrands());
        result.addObject("categories", this.categoryService.getCategories());
        result.addObject("product", new Product());
        return result;
    }

    //TODO Esto de momento no se usa, terminar o eliminar
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("product") Product product) {
        productService.add(product);
        return "redirect:listado";
    }

    @GetMapping("/listado")
    public ModelAndView list() {
        ModelAndView result = new ModelAndView("product/list");
        result.addObject("products", this.productService.getProducts());
        return result;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView edit(@PathVariable("id")long id){
        ModelAndView result = new ModelAndView("product/edit");
        result.addObject("product", this.productService.getProduct(id));
        return result;
    }
    @GetMapping("/marcas")
    public ModelAndView brand() {
        ModelAndView result = new ModelAndView("search/brand");
        result.addObject("marca", this.brandService.getBrands());
        return result;
    }

    @GetMapping("/categorias")
    public ModelAndView category() {
        ModelAndView result = new ModelAndView("search/category");
        result.addObject("categoria", this.categoryService.getCategories());
        return result;
    }


}
