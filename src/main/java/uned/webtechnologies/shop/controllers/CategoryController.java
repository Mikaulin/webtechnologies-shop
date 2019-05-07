package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.services.CategoryService;
import uned.webtechnologies.shop.services.ProductService;
/** Controlador para gestionar las categorias de la vista-modelo
 * Responde a las URLs "/categorias(/..)*"
 *
 *
 */

@Controller
@RequestMapping("/categorias")
public class CategoryController {
    private CategoryService categoryService;
    private ProductService productService;

    /**Construye un controlador con un CategoryService y un ProductService
     * @param categoryService CategoryService interactuar con las categorias
     * @param productService ProductService para interactuar con los productos.
     * @see CategoryService
     * @see ProductService
     */
    @Autowired
    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    /**Método que responde a la solicitud get ("/categorias")
     * poniendo a disposición de la vista ("category/list")
     * la lista de marcas del sistema
     * @return ModelAndView (category/list) con la lista de marcas "categories"
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see CategoryService#getCategories()
     *
     */
    @GetMapping()
    public ModelAndView list() {
        ModelAndView result = new ModelAndView("category/list");
        result.addObject("categories", this.categoryService.getCategories());
        return result;
    }

    /**Método que responde a la solicitud get ("/categorias/{id}"), donde {id} es el identificador de la categoría
     * poniendo a disposición de la vista ("category/detail")
     * las categorías y la lista de productos que pertencen a la categoría solicitada
     * @param id Identificador único de la Categoría
     * @return ModelAndView "category/detail" con las categorías y la lista de productos de una categoría "products" y "category"
     * @see ProductService#getProductsByCategoryId(long)
     * @see CategoryService#getCategories()
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     */
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
