package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.services.CartService;
import uned.webtechnologies.shop.services.UserService;

@Controller
@RequestMapping("/carrito")
public class CartController {

    private CartService cartService;
    private UserService userService;

    @Autowired
    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }


    @GetMapping()
    public ModelAndView list(@AuthenticationPrincipal UserDetails activeUser) {
        ModelAndView result = new ModelAndView("cart/list");

        return listCart(result, activeUser);
    }

    @GetMapping("/orden")
    public ModelAndView orden(@AuthenticationPrincipal UserDetails activeUser) {
        ModelAndView result = new ModelAndView("cart/order");

        return listCart(result, activeUser);
    }


    private ModelAndView listCart(ModelAndView result, UserDetails activeUser) {
        if (activeUser != null) {
            User user = userService.findByUsername(activeUser.getUsername());
            result.addObject("carts", this.cartService.findByUser(user));
            result.addObject("total", this.cartService.userTotal(user));
            result.addObject("subtotal", this.cartService.userSubtotal(user));
            result.addObject("iva", this.cartService.userIVA(user));
            result.addObject("user", this.userService.getUser(user.getId()));

        }
        return result;

    }

}
