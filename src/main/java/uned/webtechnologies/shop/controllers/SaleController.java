package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.services.PurchaseLineService;
import uned.webtechnologies.shop.services.UserService;

import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    @GetMapping("/fecha")
    public ModelAndView saleDate() {
        ModelAndView result = new ModelAndView("sale/date");
        result.addObject("date", new String());
        return result;
    }

    @RequestMapping(value = "/informe", method = RequestMethod.POST)
    public ModelAndView report(@ModelAttribute  String date) {
        ModelAndView result = new ModelAndView("sale/report");
       // result.addObject("date", date);
        result.addObject("lines", this.purchaseLineService.getPurchasesByDate(new GregorianCalendar(2019,10,01)));
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
