package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.services.CartService;
import uned.webtechnologies.shop.services.UserService;
/** Controlador para gestionar las Lineas de carrito de la vista-modelo
 * Responde a las URLs "/carrito(/..)*"
 *
 *
 */

@Controller
@RequestMapping("/carrito")
public class CartController {

    private CartService cartService;
    private UserService userService;

    /**Construye un controlador con un CartService y un UserService
     * @param cartService CartService para interactuar con las lineas de Carrito
     * @param userService UserService para interactuar con los usuarios
     * @see CartService
     * @see UserService
     */
    @Autowired
    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }


    /**Método que responde a la solicitud get("carrito")
     * poniendo a disposición de la vista la lista de lineas de carrito del usuario conectado
     * @param activeUser Usuario conectado
     * @return ModelAndView ("cart/list") con la lista de lineas de carrito del usuario conectado
     * @see UserDetails
     * @see  <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     */
    @GetMapping()
    public ModelAndView list(@AuthenticationPrincipal UserDetails activeUser) {
        ModelAndView result = new ModelAndView("cart/list");

        return listCart(result, activeUser);
    }

    /**Método que responde a la solicitud get("/carrito/orden")
     * poniendo a disposición de la vista la lista de lineas de carrito del usuario conectado
     * @param activeUser Usuario conectado
     * @return ModelAndView ("cart/list") con la lista de lineas de carrito del usuario conectado
     * @see UserDetails
     * @see  <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     */
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
