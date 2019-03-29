package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.services.BrandService;
import uned.webtechnologies.shop.services.ProductService;

@Controller
@RequestMapping("/marcas")
public class BrandController {

    private BrandService brandService;
    private ProductService productService;

    @Autowired
    public BrandController(BrandService brandService, ProductService productService) {
        this.brandService = brandService;
        this.productService = productService;
    }

    @GetMapping()
    public ModelAndView list() {
        ModelAndView result = new ModelAndView("brand/list");
        result.addObject("brands", this.brandService.getBrands());
        return result;
    }

    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable("id") long id) {
        ModelAndView result = new ModelAndView("brand/detail");
        result.addObject("products", this.productService.getProductsByBrandId(id));
        //TODO Las marcas, ya que se repite el HTML en varias ocasiones, lo suyo sería sacar esto a una vista parcial
        /// como las que tenemos en shared y así dividimos responsabilidades
        result.addObject("brand", this.brandService.getBrands());
        return result;
    }
}
