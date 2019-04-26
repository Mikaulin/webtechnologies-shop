package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.services.BrandService;
import uned.webtechnologies.shop.services.CategoryService;
import uned.webtechnologies.shop.services.ProductService;
import uned.webtechnologies.shop.services.PromotionService;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/admin/producto")
public class ProductAdminController {
    private ProductService productService;
    private CategoryService categoryService;
    private BrandService brandService;
    private PromotionService promotionService;

    @Autowired
    public ProductAdminController(ProductService productService, CategoryService categoryService, BrandService brandService, PromotionService promotionService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.brandService = brandService;
        this.promotionService = promotionService;
    }

    @GetMapping("/alta")
    public ModelAndView create() {
        ModelAndView result = new ModelAndView("product/productform");
        result.addObject("brands", this.brandService.getBrands());
        result.addObject("categories", this.categoryService.getCategories());
        result.addObject("promotion", this.promotionService.getPromotions());
        result.addObject("product", new Product());
        return result;
    }

    @RequestMapping(value = "/alta", method = RequestMethod.POST)
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
        result.addObject("promotion", this.promotionService.getPromotions());
        result.addObject("categoryList", this.categoryService.getCategories());
        result.addObject("product", this.productService.getProduct(id));
        result.addObject("productPromo", this.productService.getPromotionsByProductId(id));
        return result;
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable("id") long id, @ModelAttribute("product") Product product) {
        productService.update(id, product);
        return "redirect:/admin/producto/listado";
    }
}
