package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.services.*;

@Controller
@RequestMapping("/compra")
public class PurchaseLineController {

    private ProductService productService;
    private PurchaseLineService purchaseLineService;
    private UserService userService;
    private CartService cartService;

    @Autowired
    public PurchaseLineController(ProductService productService,
                                  PurchaseLineService purchaseLineService,
                                  CartService cartService,
                                  UserService userService) {
        this.productService = productService;
        this.purchaseLineService = purchaseLineService;
        this.cartService = cartService;
        this.userService = userService;
    }


    @GetMapping("/confirmacion")
    public ModelAndView purchaseBuy(@AuthenticationPrincipal UserDetails activeUser) {
        ModelAndView result = new ModelAndView("purchase/purchaseOk");
        if (activeUser != null) {
            User user = userService.findByUsername(activeUser.getUsername());
            this.purchaseLineService.saveCarts(this.cartService.findByUser(user));
            this.cartService.removeAllOfUser(user);
        }
        return result;
    }

    @GetMapping("/listado")
    public ModelAndView purchaseLines(@AuthenticationPrincipal UserDetails activeUser) {

        ModelAndView result = new ModelAndView("purchase/list");
        if (activeUser != null) {
            User user = userService.findByUsername(activeUser.getUsername());
            result.addObject("purchaseLines", this.purchaseLineService.getPurchaseLines(user));
        }
        return result;
    }


}
