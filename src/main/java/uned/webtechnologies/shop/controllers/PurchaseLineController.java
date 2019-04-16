package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.PurchaseLine;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.services.*;

@Controller
@RequestMapping("/compra")
public class PurchaseLineController {

    private PurchaseLineService purchaseLineService;
    private UserService userService;
    private CartService cartService;

    @Autowired
    public PurchaseLineController(PurchaseLineService purchaseLineService,
                                  CartService cartService,
                                  UserService userService) {

        this.purchaseLineService = purchaseLineService;
        this.cartService = cartService;
        this.userService = userService;
    }

    /*Este metodo maneja una excepcion probocada por el
     purchaseLineService en en caso de no poder realizar la compra de alguna de
    las lineas de Cart y pone a disposicion de la vista un String con el mensaje.
    Si se quiere modificar el mensaje de error, habra que hacerlo en el PurchaseLineService*/

    @GetMapping("/confirmacion")
    public ModelAndView purchaseBuy(@AuthenticationPrincipal UserDetails activeUser) {
        ModelAndView result = new ModelAndView();
        if (activeUser != null) {

            User user = userService.findByUsername(activeUser.getUsername());
            try { result.setViewName("purchase/purchaseOk");

                result.addObject("mensaje","Compra realizada con exito");

                this.purchaseLineService.saveCarts(this.cartService.findByUser(user));
            } catch (Exception e) {
                result.setViewName("purchase/purchaseWrong");//este jsp no existe
                e.printStackTrace();
                result.addObject("mensaje",e.getMessage());
            }
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
    @GetMapping("/detalle/{id}")
    public ModelAndView detail(@PathVariable("id") long id) {
        ModelAndView result = new ModelAndView("purchase/detail");
        result.addObject("purchase", this.purchaseLineService.getOne(id));
        return result;
    }
    @PostMapping(value = "/delete")
    public String delete(@RequestParam("id")long id) {
        purchaseLineService.returnPurchase(this.purchaseLineService.getOne(id));

        return "redirect:/user/usuarios";
    }


}
