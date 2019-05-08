package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.services.BrandService;
import uned.webtechnologies.shop.services.ProductService;

/** Controlador para gestionar las marcas de la vista-modelo
 * <P>Responde a las URLs "/marcas(/..)*"</P>
 *
 */

@Controller
@RequestMapping("/marcas")
public class BrandController {

    private BrandService brandService;
    private ProductService productService;

    /**Construye un controlador con un BrandSerivce y un ProductService
     * @param brandService BrandService que interactua con las marcas
     * @param productService ProductService que interactura con los productos.
     * @see BrandService
     * @see ProductService
     */
    @Autowired
    public BrandController(BrandService brandService, ProductService productService) {
        this.brandService = brandService;
        this.productService = productService;
    }

    /**Método que responde a la solicitud get ("/marcas")
     * poniendo a disposición de la vista ("brand/list") la lista de marcas del sistema
     * @return ModelAndView "brand/list" con la lista de marcas "brands"
     * @see BrandService
     * @see uned.webtechnologies.shop.inmemorydb.model.Brand
     * @see  <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     */
    @GetMapping()
    public ModelAndView list() {
        ModelAndView result = new ModelAndView("brand/list");
        result.addObject("brands", this.brandService.getBrands());
        return result;
    }

    /**Método que responde a la solicitud get ("/marcas/{id}") donde {id} es el identificador de la marca
     * @param id Identificador único de la marca a la que deben pertenecer los productos
     * @return ModelAndView "brand/detail" con una Lista de productos que pertenecen a una marca concreta "products" y la lista de marcas del sistema "brands"
     * @see ProductService#getProductsByBrandId(long)
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     */
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
