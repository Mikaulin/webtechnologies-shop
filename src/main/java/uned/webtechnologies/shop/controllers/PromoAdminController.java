package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.Promotion;
import uned.webtechnologies.shop.services.PromotionService;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/admin/promociones")
public class PromoAdminController {

    private PromotionService promotionService;

    @Autowired
    public PromoAdminController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping("/listado")
    public ModelAndView promo() {
        ModelAndView result = new ModelAndView("promo/list");
        result.addObject("promotion", this.promotionService.getPromotions());
        return result;
    }

    @GetMapping("/crear")
    public ModelAndView promoform() {
        ModelAndView result = new ModelAndView("promo/create");
        result.addObject("promotion", this.promotionService.getPromotions());
        result.addObject("promotionForm", new Promotion());
        return result;
    }


    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String create(@ModelAttribute("promo") Promotion promo) {
        promotionService.save(promo);
        return "redirect:/admin/promociones/listado";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editpromo(@PathVariable("id") long id) {
        ModelAndView result = new ModelAndView("promo/edit");
        result.addObject("promotion", this.promotionService.getPromotions());
        result.addObject("editPromo", this.promotionService.getPromotion(id));
        return result;
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable("id") long id, @ModelAttribute("promotion") Promotion promotion) {
        promotionService.update(id, promotion);
        return "redirect:/admin/promociones/listado";
    }

}
