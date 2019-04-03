package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.services.*;

@Controller
@RequestMapping("/producto")
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;
    private BrandService brandService;
    private PromotionService promotionService;
    private RatingService ratingService;
    private UserService userService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService, BrandService brandService, PromotionService promotionService, RatingService ratingService, UserService userService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.brandService = brandService;
        this.promotionService = promotionService;
        this.ratingService = ratingService;
        this.userService = userService;
    }

    @GetMapping("/detalle/{id}")
    public ModelAndView detail(@PathVariable("id") long id) {
        ModelAndView result = new ModelAndView("product/detail");
        result.addObject("product", this.productService.getProduct(id));
        return result;
    }

    @GetMapping("/alta")
    public ModelAndView create() {
        ModelAndView result = new ModelAndView("product/productform");
        result.addObject("brands", this.brandService.getBrands());
        result.addObject("categories", this.categoryService.getCategories());
        result.addObject("promotion", this.promotionService.getActivePromotions());
        result.addObject("product", new Product());
        return result;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:listado";
    }

    @GetMapping("/listado")
    public ModelAndView list() {
        ModelAndView result = new ModelAndView("product/list");
        result.addObject("products", this.productService.getProducts());
        return result;
    }


    @GetMapping("/editar/{id}")
    public ModelAndView edit(@PathVariable("id") long id) {
        ModelAndView result = new ModelAndView("product/edit");
        result.addObject("brandList", this.brandService.getBrands());
        result.addObject("categoryList", this.categoryService.getCategories());
        result.addObject("product", this.productService.getProduct(id));
        return result;
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable("id") long id, @ModelAttribute("product") Product product) {
        productService.update(id, product);
        return "redirect:/producto/listado";
    }

    @GetMapping("/valoraciones")
    public ModelAndView rating() {
        ModelAndView result = new ModelAndView("search/rating");
        return result;
    }

    @GetMapping("/valoraciones/{id}")
    public ModelAndView ratinglist(@PathVariable("id") int id) {
        ModelAndView result = new ModelAndView("search/list");
        result.addObject("products", this.ratingService.getProductsByRating(id));
        result.addObject("rating", this.ratingService);
        return result;
    }



    @GetMapping("/ventas/listado")
    public ModelAndView listVentas() {
        ModelAndView result = new ModelAndView("sale/list");
        result.addObject("products", this.productService.getProducts());
        result.addObject("users", this.userService.getUser());
        return result;
    }


}
