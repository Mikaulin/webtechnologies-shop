package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.services.ProductService;
import uned.webtechnologies.shop.services.RatingService;

/**Controlador de productos
 *
 */

@Controller
@RequestMapping("/producto")
public class ProductController {

    private ProductService productService;
    private RatingService ratingService;

    /**Construye un controlador de productos
     * @param productService Servicio para interactuar con los productos
     * @param ratingService Servicio para interacturar con los Ratings
     * @see ProductService
     * @see RatingService
     *
     */
    @Autowired
    public ProductController(ProductService productService, RatingService ratingService) {
        this.productService = productService;
        this.ratingService = ratingService;
    }


    /**Método
     * @param id
     * @return
     */
    @GetMapping("/detalle/{id}")
    public ModelAndView detail(@PathVariable("id") long id) {
        ModelAndView result = new ModelAndView("product/detail");
        result.addObject("product", this.productService.getProduct(id));
        return result;
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
        return result;
    }

}
