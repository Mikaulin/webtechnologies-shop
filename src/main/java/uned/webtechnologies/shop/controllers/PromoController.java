package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.Promotion;
import uned.webtechnologies.shop.services.PromotionService;
import uned.webtechnologies.shop.services.RatingService;

@Controller
@RequestMapping("/promociones")
public class PromoController {


    private PromotionService promotionService;
    private RatingService ratingService;


    @Autowired
    public PromoController(PromotionService promotionService, RatingService ratingService) {
        this.promotionService = promotionService;
        this.ratingService = ratingService;
    }


    @GetMapping("/{id}")
    public ModelAndView promolist(@PathVariable("id") long id) {
        ModelAndView result = new ModelAndView("promo/listproductpromo");
        result.addObject("products", this.promotionService.getProductsByPromotionId(id));
        result.addObject("promotion", this.promotionService.getActivePromotions());
        result.addObject("rating", this.ratingService);
        return result;
    }

    @GetMapping("")
    public ModelAndView promotion() {
        ModelAndView result = new ModelAndView("promo/promotion");
        result.addObject("promotion", this.promotionService.getActivePromotions());
        return result;
    }

    @GetMapping("/listado")
    public ModelAndView promo() {
        ModelAndView result = new ModelAndView("promo/list");
        result.addObject("promotion", this.promotionService.getPromotions());
        return result;
    }

    @GetMapping("/altaPromociones")
    public ModelAndView promoform() {
        ModelAndView result = new ModelAndView("promo/promoform");
        result.addObject("promotion", this.promotionService.getActivePromotions());
        result.addObject("promotionForm", new Promotion());
        return result;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("promo") Promotion promo) {
        promotionService.save(promo);
        return "redirect:/promociones/listado";
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
        return "redirect:/promociones/listado";
    }


}
