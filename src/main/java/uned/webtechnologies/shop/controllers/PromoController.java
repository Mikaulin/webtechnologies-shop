package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.services.PromotionService;
import uned.webtechnologies.shop.services.RatingService;

/**
 * Controlador que gestiona las promociones en la vista-modelo .
 * Responde a las URLs "/promociones(/..)*"
 *
 */

@Controller
@RequestMapping("/promociones")
public class PromoController {

    private PromotionService promotionService;
    private RatingService ratingService;

    /**Construye un controlador con el servicio de promociones y el servicio de Ratings
     * @param promotionService Servicio de promociones con el que interactuar
     * @see PromotionService
     */
    @Autowired
    public PromoController(PromotionService promotionService, RatingService ratingService) {
        this.promotionService = promotionService;
        this.ratingService = ratingService;
    }


    /**Método que responde a la solicitud GET ("/{id}")
     * poniendo a disposición de la vista "promo/listproductpromo"  las promociones activas del sistema
     * y la lista de productos que pertenecen a una promoción concreta donde
     * {id} es el identificador único de la promoción concreta
     * @param id Identficicador único de la promoción de la que se desean los productos
     * @return ModelAndView "promo/listproductpromo" con la lista de promociones activas del sistema,
     * y la lista de productos que pertenecen a una promoción concreta donde
     * {id} es el identificador único de la promoción concreta
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see PromotionService#getProductsByPromotionId(long)
     * @see PromotionService#getActivePromotions()
     */
    @GetMapping("/{id}")
    public ModelAndView promolist(@PathVariable("id") long id) {
        ModelAndView result = new ModelAndView("promo/listproductpromo");
        result.addObject("products", this.promotionService.getProductsByPromotionId(id));
        result.addObject("promotion", this.promotionService.getActivePromotions());
        return result;
    }

    /**Método que responde a la solicitud GET ("promociones") poniendo a disposición de la vista "promo/promotion"
     * la lista de promociones activas del sistema
     * @return ModelAndView "promo/promotion" con la lista de promociones activas del sistema
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see PromotionService#getActivePromotions()
     */
    @GetMapping("")
    public ModelAndView promotion() {
        ModelAndView result = new ModelAndView("promo/promotion");
        result.addObject("promotion", this.promotionService.getActivePromotions());
        return result;
    }
}
