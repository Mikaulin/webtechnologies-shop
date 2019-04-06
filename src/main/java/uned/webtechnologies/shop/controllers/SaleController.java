package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.services.PurchaseLineService;
import uned.webtechnologies.shop.services.UserService;

@Controller
@RequestMapping("/ventas")
public class SaleController {

    private UserService userService;
    private PurchaseLineService purchaseLineService;

    @Autowired
    public SaleController(PurchaseLineService purchaseLineService, UserService userService) {
        this.purchaseLineService = purchaseLineService;
        this.userService = userService;
    }

    @GetMapping("/listado")
    public ModelAndView listPurchaseLines() {
        ModelAndView result = new ModelAndView("sale/list");
        result.addObject("lines", this.purchaseLineService.getAllPurchases());
        return result;
    }

    @GetMapping("/informe")
    public ModelAndView report() {
        ModelAndView result = new ModelAndView("sale/report");
        result.addObject("detailUser", this.userService.getUser());
        result.addObject("lines", this.purchaseLineService.getAllPurchases());
        return result;
    }

    @GetMapping("/historial/{username}")
    public ModelAndView listHistory(@PathVariable("username") String username) {
        ModelAndView result = new ModelAndView("sale/history");
        result.addObject("user", this.userService.findByUsername(username));
        result.addObject("lines", this.purchaseLineService.getAllPurchases());
        return result;
    }


}
