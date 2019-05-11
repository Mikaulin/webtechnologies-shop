package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uned.webtechnologies.shop.inmemorydb.model.PurchaseLine;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.services.PurchaseLineService;
import uned.webtechnologies.shop.services.UserService;

import java.util.*;
/** Controlador para gestionar las compras de la vista-modelo,solo accesible para usuarios con el ROLE de ADMINISTRADOR
 * <P>Responde a las URLs "/admin/ventas(/..)*"</P>
 *
 *
 */

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/admin/ventas")
public class SaleAdminController {

    private UserService userService;
    private PurchaseLineService purchaseLineService;

    /**<p>Construye un controlador con los servicios</p>
     * <ul>
     *     <li>Lineas de compra ("PurchaseLineService")</li>
     *     <li>Usuarios ("UserService")</li>
     * </ul>
     * @param purchaseLineService Servicio de lineas de compra
     * @param userService Servicio de usuarios
     * @see PurchaseLineService
     * @see UserService
     */
    @Autowired
    public SaleAdminController(PurchaseLineService purchaseLineService, UserService userService) {
        this.purchaseLineService = purchaseLineService;
        this.userService = userService;
    }

    /**Método que responde a la solicitud GET ("admin/ventas/listado")
     * poniendo a disposición de la vista ("sale/list") la lista de lineas de compra del sistema ("lines")
     * @return ModelAndView ("sale/list") con la lista de las lineas de compra del sistema ("lines")
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see PurchaseLineService#getAllPurchases()
     */
    @GetMapping("/listado")
    public ModelAndView listPurchaseLines() {
        ModelAndView result = new ModelAndView("sale/list");
        result.addObject("lines", this.purchaseLineService.getAllPurchases());
        return result;
    }

    /**Método que responde a la solicitud GET ("admin/ventas/fecha")
     * poniendo a disposición de la vista ("sale/date") un objeto Date ("date") para rellenar con una fecha
     * @return ModelAndView ("sale/date") con un Date ("date") para ser rellenado
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Date.html">Date</a>
     */

    @GetMapping("/fecha")
    public ModelAndView saleDate() {
        ModelAndView result = new ModelAndView("sale/date");
        result.addObject("date", new Date());
        return result;
    }

    /**<p>Método que responde a la solicitud POST ("admin/ventas/informe")</p>
     * <p>recibiendo una cadena de texto que representa una fecha y poniendo </p>
     * <p>a disposición de la vista ("sale/report") lo necesario para imprimir un informe de ventas por fecha</p>
     * <ul>
     *     <li>La fecha "date"</li>
     *     <li>El día "day"</li>
     *     <li>El mes "month"</li>
     *     <li>El año "year"</li>
     *     <li>La lista de usuarios que hicieron compras en la fecha indicada "users"</li>
     *
     * </ul>
     * @param date Fecha sobre la que se quiere obtener el informe de ventas
     * @return ModelAndView ("sale/report") con :
     * <ul>
     *     <li>La fecha "date"</li>
     *     <li>El día "day"</li>
     *     <li>El mes "month"</li>
     *     <li>El año "year"</li>
     *     <li>La lista de usuarios que hicieron compras en la fecha indicada "users"</li>
     *
     * </ul>
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Date.html">Date</a>
     * @see PurchaseLineService#getPurchasesByDate(Calendar)
     *
     *
     */
    @RequestMapping(value = "/informe", method = RequestMethod.POST)
    public ModelAndView report(@ModelAttribute("date") String date) {
        ModelAndView result = new ModelAndView("sale/report");
        int day = Integer.parseInt(date.substring(8, 10));
        int month = Integer.parseInt(date.substring(5, 7));
        int year = Integer.parseInt(date.substring(0, 4));

        Calendar cal = new GregorianCalendar(year, month - 1, day);
        result.addObject("date", cal);
        result.addObject("day", day);
        result.addObject("month", month);
        result.addObject("year", year);
        List<PurchaseLine> lines = this.purchaseLineService.getPurchasesByDate(cal);
        Set<User> user = new HashSet<>();
        for (PurchaseLine l : lines
        ) {
            user.add(l.getUser());

        }
        result.addObject("users", user);
        //  result.addObject("lines", this.purchaseLineService.getPurchasesByDate(cal));
        return result;
    }
    /**<p>Método que responde a la solicitud GET ("admin/ventas/historial/{username}")</p>
     * <p>Poniendo a disposición de la vista "sale/history"</p>
     * <p>el historial de ventas de un usuario concreto</p>
     * <p>donde {username} corresponde con el nombre del usuario</p>
     * @param username Cadena con el nombre del usuario del que se quiere obtener el historial
     * @return ModelAndView ("sale/history") con el
     * <p>usuario "user" del que se quiere obtener el historial</p>
     * <p> y la lista completa de las compras realizadas por el usuario "lines"</p>
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see UserService#findByUsername(String)
     * @see PurchaseLineService#getPurchaseLines(User)
     *
     */
    @GetMapping("/historial/{username}")
    public ModelAndView listHistory(@PathVariable("username") String username) {
        ModelAndView result = new ModelAndView("sale/history");
        User user=this.userService.findByUsername(username);
        result.addObject("user",user);
        result.addObject("lines", purchaseLineService.getPurchaseLines(user));

        return result;
    }

    /**<p>Método que responde a la solicitud GET ("/admin/ventas/detalle/{id}")</p>
     * <p> poniendo a disposición de la vista "purchase/detail" los detalles de la compra "purchase" en concreto con id = {id}</p>
     *
     * @param id Identificador único de la compra que se obtienen los detalles
     * @return ModelAndView "purchase/detail" con la compra solicitada "purchase"
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see PurchaseLineService#getOne(long)
     *
     *
     */
    @GetMapping("/detalle/{id}")
    public ModelAndView detail(@PathVariable("id") long id) {
        ModelAndView result = new ModelAndView("purchase/detail");
        result.addObject("purchase", this.purchaseLineService.getOne(id));
        return result;
    }

    /**<p>Método que responde a la solicitud POST ("admin/ventas/delete")</p>
     * <p>recibiendo un el id de la compra a devolver y solicitando al serviccio que sea borrada</p>
     * @param id Identificador único de la compra a devolver
     * @return Cadena que redireccion a "/admin/usuarios/listado"
     * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html">ModelAndView</a>
     * @see PurchaseLineService#returnPurchase(PurchaseLine)
     */
    @PostMapping(value = "/delete")
    public String delete(@RequestParam("id")long id) {
        purchaseLineService.returnPurchase(this.purchaseLineService.getOne(id));
        return "redirect:/admin/usuarios/listado";
    }



}
