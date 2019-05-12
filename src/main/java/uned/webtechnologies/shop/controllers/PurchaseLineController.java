
package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.services.CartService;
import uned.webtechnologies.shop.services.PurchaseLineService;
import uned.webtechnologies.shop.services.UserService;

import java.util.List;

/**
 * Controlador de lineas de compra
 * <p>Responde a las URLs "/compra(/..)*"</p>
 */

@Controller
@RequestMapping("/compra")
public class PurchaseLineController {

    private PurchaseLineService purchaseLineService;
    private UserService userService;
    private CartService cartService;

    /**Construye un controlador con los servicios de Lineas de compra, lineas de carrito y usuarios
     * @param purchaseLineService Servicio de lineas de compra
     * @param cartService Servicio de lineas de carrito
     * @param userService Servicio de usuarios
     * @see PurchaseLineService
     * @see CartService
     * @see UserService
     */
    @Autowired
    public PurchaseLineController(PurchaseLineService purchaseLineService,
                                  CartService cartService,
                                  UserService userService) {

        this.purchaseLineService = purchaseLineService;
        this.cartService = cartService;
        this.userService = userService;
    }

    /**Método que responde a la solicitud GET ("/compra/confirmación")
     * Este metodo maneja una excepcion probocada por el
     * purchaseLineService en en caso de no poder realizar la compra de alguna de
     * las lineas de Cart y pone a disposicion de la vista un String con el mensaje.
     * <p>Si se quiere modificar el mensaje de error, habra que hacerlo en el PurchaseLineService</p>
     *
     *
     * @param activeUser Usuario autenticado que quiere realizar la compra
     * @return ModelAndView con diferentes propiedades según el resultado de la compra.
     * <ul>
     *     <li>Si la compra se realiza con éxito
     *     <ul>
     *     <li>Devueve un ModelAndView con la vista "purchase/purchaseOk" y mensaje de éxito "mensaje"
     *     <li>Guarda las lineas de carro como compra
     *     <li>Borra las lineas de carrito del usuario</ul></li>
     *     <li>Si algún producto del carrito no se puede comprar por falta de stock
     *     <ul>
     *     <li>Devuelve un ModelAndView con la vista "purchase/purchaseWrong" y el mensaje de error "mensaje"</ul></li>
     *  </ul>
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see PurchaseLineService#saveCarts(List)
     * @see CartService#removeAllOfUser(User)
     * */

    @GetMapping("/confirmacion")
    public ModelAndView purchaseBuy(@AuthenticationPrincipal UserDetails activeUser) {
        ModelAndView result = new ModelAndView();
        if (activeUser != null) {
            User user = userService.findByUsername(activeUser.getUsername());
            try {
                result.setViewName("purchase/purchaseOk");
                result.addObject("mensaje","Tu compra ha sido realizada con exito. Agradecemos tu confianza.");

                this.purchaseLineService.saveCarts(this.cartService.findByUser(user));
            } catch (Exception e) {
                result.setViewName("purchase/purchaseWrong");
                e.printStackTrace();
                result.addObject("mensaje",e.getMessage());
            }

        }
        return result;
    }

    /**Método que responde a la solicitud GET ("/compra/listado") poniendo a disposición de la vista "Purchase/list")
     * la lista de lienas de compra de un usuario concreto.
     * @param activeUser Usuario del que se obtienen las lineas de compra
     * @return ModelAndView "purchase/list" con la lista de lienas de compra del usuario "purchaseLines"
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see PurchaseLineService#getPurchaseLines(User)
     */
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