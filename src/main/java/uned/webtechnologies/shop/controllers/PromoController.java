package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
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
}
