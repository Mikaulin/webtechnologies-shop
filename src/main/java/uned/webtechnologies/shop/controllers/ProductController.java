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


    /**Método que responde a la solicitud GET ("/producto/detalle/{id}") poniendo a disposición de la vista
     * un producto, donde {id} es el identificador único del producto que se requiere
     * @param id Identificador único del producto
     * @return ModelAndView ("product/detail") con el producto que se solicita
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see ProductService#getProduct(long)
     *
     */
    @GetMapping("/detalle/{id}")
    public ModelAndView detail(@PathVariable("id") long id) {
        ModelAndView result = new ModelAndView("product/detail");
        result.addObject("product", this.productService.getProduct(id));
        return result;
    }

    /**Método que responde a la solicitud GET ("/producto/valoraciones") redireccionando a la
     * correspondiente vista
     *
     * @return ModelAndView ("search/rating")
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     *
     */
    @GetMapping("/valoraciones")
    public ModelAndView rating() {
        ModelAndView result = new ModelAndView("search/rating");
        return result;
    }

    /**Método que responde a la solicitud GET ("producto/valoraciones/[id}")
     * poniendo a disposición de la vista ("serach/list") los productos que tienen una valoración concreta
     * donden {id} es la valoración solicitada
     * @param id Identificador único de la valoración
     * @return ModelAndView ("search/list") con la lista de poductos que tienen la valoración solicitada
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see RatingService#getProductRating(long)
     */
    @GetMapping("/valoraciones/{id}")
    public ModelAndView ratinglist(@PathVariable("id") int id) {
        ModelAndView result = new ModelAndView("search/list");
        result.addObject("products", this.ratingService.getProductsByRating(id));
        return result;
    }

}
