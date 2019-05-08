package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.Promotion;
import uned.webtechnologies.shop.services.PromotionService;

/**
 * Controlador que gestiona las promociones de la vista-modelo , solo accesible para el ROLE de ADMINISTRADOR
 * <p>Responde a las URLs "/admin/promociones(/..)*"</p>
 *
 */
@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/admin/promociones")
public class PromoAdminController {

    private PromotionService promotionService;

    @Autowired
    public PromoAdminController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    /**Método que responde a la solicitud GET ("/listado") poniendo a dispocición de
     * la vista "promo/list" la lista de promociones del sistema.
     *
     * @return ModelAndView ("promo/list") con la lista de promociones del sistema "promotion"
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see PromotionService#getPromotions()
     */
    @GetMapping("/listado")
    public ModelAndView promo() {
        ModelAndView result = new ModelAndView("promo/list");
        result.addObject("promotion", this.promotionService.getPromotions());
        return result;
    }

    /**Método que responde a la solicitud GET ("crear") poniendo a disposición de
     * la vista "promo/create" la lista de promociones del sistema y una nueva promocion vacia
     * @return ModelAndView "promo/create" con la lista de promociones del sistema "promotion" y una nueva promocion vacia "promotionForm"
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see PromotionService#getActivePromotions() ()
     */
    @GetMapping("/crear")
    public ModelAndView promoform() {
        ModelAndView result = new ModelAndView("promo/create");
        result.addObject("promotion", this.promotionService.getActivePromotions());
        result.addObject("promotionForm", new Promotion());
        return result;
    }


    /**Método que responde a la solicitud POST ("admin/promociones/crear") que recibe una promoción
     * en la solicitud , la guarda y redireccion a "admin/promociones/listado"
     * @param promo Promocion rellenada vía formulario para ser guardada en el sistema
     * @return Cadena de texto que redirecciona a "/admin/promociones/listado"
     * @see PromotionService#save(Promotion)
     */
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String create(@ModelAttribute("promo") Promotion promo) {
        promotionService.save(promo);
        return "redirect:/admin/promociones/listado";
    }

    /**Método que responde a la solicitud GET ("admin/promociones/editar/{id}")
     * poniendo a disposición de la vista "promo/edit" la lista de promociones del sistema y una
     * promociones concreta para poder ser editada donde {id} es el identificador único de la promoción a editar
     * @param id Identificador único de la promoción a editar
     * @return ModelAndView "promo/edit" con las promociones del sistema "promotion" y la promoción que se quiere editar"editPromo"
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see PromotionService#getPromotions()
     * @see PromotionService#getPromotion(long)
     *
     */
    @GetMapping("/editar/{id}")
    public ModelAndView editpromo(@PathVariable("id") long id) {
        ModelAndView result = new ModelAndView("promo/edit");
        result.addObject("promotion", this.promotionService.getPromotions());
        result.addObject("editPromo", this.promotionService.getPromotion(id));
        return result;
    }

    /**Método que responde a la solicitud POST ("admin/promociones/editar/{id}")
     * que recibe una promoción editada en la solicitud , la actualiza en el sistema y redirecciona "/admin/promociones/listado"
     * @param id Identificador único de la promocion que se quiere actualizar
     * @param promotion Promocion que contiene la nueva información
     * @return Cadena de texto que redirecciona a "/admin/promociones/listado"
     * @see PromotionService#update(long, Promotion)
     */
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable("id") long id, @ModelAttribute("promotion") Promotion promotion) {
        promotionService.update(id, promotion);
        return "redirect:/admin/promociones/listado";
    }

}
