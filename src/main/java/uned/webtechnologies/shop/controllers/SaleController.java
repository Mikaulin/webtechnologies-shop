package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.PurchaseLine;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.services.PurchaseLineService;
import uned.webtechnologies.shop.services.UserService;

import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.*;

//Todo esta clase creo que no tiene sentido, para esto están los controladores PurchaseLineController SaleAdminController
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


    @GetMapping("/historial")
    public ModelAndView listHistory(@AuthenticationPrincipal UserDetails activeUser) {
        ModelAndView result = new ModelAndView("sale/history");
        User user=this.userService.findByUsername(activeUser.getUsername());
        result.addObject("user",user);
        result.addObject("lines", user.getPurchaseLines());
        return result;
    }


}
