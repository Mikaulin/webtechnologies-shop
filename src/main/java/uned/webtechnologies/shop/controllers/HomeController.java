
package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.services.ProductService;
import uned.webtechnologies.shop.services.PurchaseLineService;
/** Controlador para gestionar la página principal
 * <p>Responde al directorio Raiz y sus hijos</p>
 *
 *
 */

@Controller
@RequestMapping
public class HomeController {

    private ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;

    }

    /**Método que pone a disposición de la pagina principal una lista de productos destacados
     * y una lista con todos los productos
     * @return ModelAndView "index" con productos destacados "feturedProducts" y todos los productos "products"
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see ProductService#getFeaturedProducts()
     * @see ProductService#getProducts()
     */
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView result = new ModelAndView("index");
        result.addObject("featuredProducts", this.productService.getFeaturedProducts());
        result.addObject("products", this.productService.getProducts());
        return result;
    }

    /**Método que responde a la solicitud get ("/servicios") devolviendo la vista "home/services"
     * @return JSP "home/services"
     *
     */
    @GetMapping("/servicios")
    public String services() {
        return "home/services";
    }

    /**Método que responde a la solicitud get ("/memoria") devolviendo la vista "home/memoria"
     * @return JSP "home/memoria"
     *
     */
    @GetMapping("/memoria")
    public String memory() {
        return "home/memoria";
    }

    /**Método que responde a la solicitud get ("/manual") devolviendo la vista "home/manual"
     * @return JSP "home/manual"
     *
     */

    @GetMapping("/manual")
    public String manual() {
        return "home/manual";
    }

}