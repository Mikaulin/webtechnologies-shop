package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.Promotion;
import uned.webtechnologies.shop.services.BrandService;
import uned.webtechnologies.shop.services.CategoryService;
import uned.webtechnologies.shop.services.ProductService;
import uned.webtechnologies.shop.services.PromotionService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Controlador  para gestionar los productos, solo accesible para usuarios con el ROLE de ADMINISTRADOR
 * <p>Responde a las URLs "/admin/producto(/..)*"</p>
 */

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/admin/producto")
public class ProductAdminController {
    private ProductService productService;
    private CategoryService categoryService;
    private BrandService brandService;
    private PromotionService promotionService;

    /**
     * Construye un controlador .
     *
     * @param productService   Servicio de productos
     * @param categoryService  Servicio de categorias
     * @param brandService     Servicio de marcas
     * @param promotionService Servicio de promociones
     * @see ProductService
     * @see CategoryService
     * @see BrandService
     * @see PromotionService
     */
    @Autowired
    public ProductAdminController(ProductService productService, CategoryService categoryService, BrandService brandService, PromotionService promotionService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.brandService = brandService;
        this.promotionService = promotionService;
    }

    /**
     * Método que responde a la solicitud get ("admin/producto/alta")
     * poniendo a disposición de la vista "product/productform") :
     * <ul>
     * <li>Lista de marcas  "brands"</li>
     * <li>Lista de categorias "categories"</li>
     * <li>Lista de promociones "promotion"</li>
     * <li>Producto vacio para ser rellenado en la vista</li>
     * </ul>
     *
     * @return ModelAndView "product/productform" con los siguientes objetos:
     * <ul>
     * <li>Lista de marcas  "brands"</li>
     * <li>Lista de categorias "categories"</li>
     * <li>Lista de promociones "promotion"</li>
     * <li>Producto vacio para ser rellenado en la vista</li>
     * </ul>
     * @see BrandService#getBrands()
     * @see CategoryService#getCategories()
     * @see PromotionService#getPromotions()
     * @see Product
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     */
    @GetMapping("/alta")
    public ModelAndView create() {
        ModelAndView result = new ModelAndView("product/productform");
        result.addObject("brands", this.brandService.getBrands());
        result.addObject("categories", this.categoryService.getCategories());
        result.addObject("promotion", this.promotionService.getPromotions());
        result.addObject("product", new Product());
        return result;
    }

    /**Método que responde a la solicitud POST ("admin/producto/alta") guardando el producto creado
     * @param product Producto creado en el formulario que se desea guardar
     * @return Cadena de texto que redirecciona la "/listado"
     * @see ProductService#save(Product)
     */
    @RequestMapping(value = "/alta", method = RequestMethod.POST)
    public String create(@ModelAttribute("product") Product product,@RequestParam("file")MultipartFile file) {
        product.setPhoto(file.getOriginalFilename());
        try {
            fileUpload(file);
            productService.save(product);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:listado";
    }

    /**Método que responde a la solicitud GET ("admin/producto/listado") poniendo a
     * disposición de la vista "product/list" la lista de productos
     * @return ModelAndView "product/list" con la lista de productos
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see ProductService#getProducts()
     */
    @GetMapping("/listado")
    public ModelAndView list() {
        ModelAndView result = new ModelAndView("product/list");
        result.addObject("products", this.productService.getProducts());
        return result;
    }

    /**Método que responde a la solicitud GET ("admin/editar/{id}") donde {id} corresponde con el
     * identificador único del producto del que se obtienen los detalles
     * @param id Identificador único del producto del que se obtienen los detalles
     * @return ModelAndView "product/edit" con la información relativa al producto
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see Product
     */
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

    /**Método que responde a la solicitud POST (admin/editar/{id}) donde {id} corresponde con el
     * identificador único que se quiere editar
     * @param id Identificador único del producto a editar
     * @param product Producto con la nueva información
     * @return Cadena de texto que redirecciona a /admin/producto/listado
     * @see ProductService#update(long, Product)
     */
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable("id") long id, @ModelAttribute("product") Product product,@RequestParam("file")MultipartFile file) {
        if(!file.getOriginalFilename().isEmpty()){
            try {
                product.setPhoto(file.getOriginalFilename());
                fileUpload(file);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        productService.update(id, product);
        return "redirect:/admin/producto/listado";
    }
    private void fileUpload(MultipartFile file) throws IOException {
        if (!file.getOriginalFilename().isEmpty()) {

            File aux= new File(".");
            File aux2=new File(aux.getParent());

            String url=aux2.getAbsolutePath();
            BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream(
                            new File(url+"/src/main/webapp/electro", file.getOriginalFilename())));
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();


        }
    }
}
