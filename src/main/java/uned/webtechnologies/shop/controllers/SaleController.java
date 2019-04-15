package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.PurchaseLine;
import uned.webtechnologies.shop.services.PurchaseLineService;
import uned.webtechnologies.shop.services.UserService;

import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
        result.addObject("date", new Date());
        return result;
    }

    @RequestMapping(value = "/informe", method = RequestMethod.POST)
    public ModelAndView report(@ModelAttribute("date") String date) {
        ModelAndView result = new ModelAndView("sale/report");
         int day= Integer.parseInt(date.substring(8,10));
         int month=Integer.parseInt(date.substring(5,7));
         int year=Integer.parseInt(date.substring(0,4));

        Calendar cal=new GregorianCalendar(year,month-1,day);
        result.addObject("day",day);
        result.addObject("month",month);
        result.addObject("year",year);
        result.addObject("lines", this.purchaseLineService.getPurchasesByDate(cal));
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
