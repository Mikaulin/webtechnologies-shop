package uned.webtechnologies.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uned.webtechnologies.shop.controllers.input.AddCartInput;
import uned.webtechnologies.shop.controllers.input.RatingInput;
import uned.webtechnologies.shop.controllers.input.UpdateCartInput;
import uned.webtechnologies.shop.controllers.output.*;
import uned.webtechnologies.shop.inmemorydb.model.Cart;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.RatingValue;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.services.*;
import uned.webtechnologies.shop.utils.StringUtils;

import javax.validation.Valid;

/**
 * Controlador configurado como REST que nos servirá para realizar las peticiones vía AJAX.
 */
@RestController
public class AjaxController {
    private UserService userService;
    private CartService cartService;
    private ProductService productService;
    private RatingService ratingService;
    private RatingValueService ratingValueService;

    /**
     * Constructor del controlador Ajax.
     *
     * @param cartService        Singleton del Servicio del carrito.
     * @param productService     Singleton del Servicio del producto.
     * @param userService        Singleton del Servicio del usuario.
     * @param ratingService      Singleton del Servicio de puntuaciones.
     * @param ratingValueService Singleton del Servicio del valores de puntuaciones.
     */
    @Autowired
    public AjaxController(
            CartService cartService,
            ProductService productService,
            UserService userService,
            RatingService ratingService,
            RatingValueService ratingValueService
    ) {
        this.cartService = cartService;
        this.productService = productService;
        this.userService = userService;
        this.ratingService = ratingService;
        this.ratingValueService = ratingValueService;
    }

    /**
     * Método privado encargado de comprobar si hay errores y generar un mensaje de error.
     *
     * @param activeUser Contiene los detalles del usuario conectado.
     * @param errors     Interfaz de errores de Spring.
     * @param output     Interfaz de salida.
     * @return Devuelve una petición incorrecta si existen errores de validación.
     * @see Output
     */
    private ResponseEntity<?> checkErrors(UserDetails activeUser, Errors errors, Output output) {
        if (errors.hasErrors()) {
            output.setMessage(StringUtils.getStringFromErrors(errors));
            return ResponseEntity.badRequest().body(output);
        } else if (activeUser == null) {
            output.setMessage("No te has conectado.");
            return ResponseEntity.badRequest().body(output);
        }
        return null;
    }

    /**
     * Método encargado de añadir una puntuación a un producto.
     *
     * @param activeUser El usuario activo.
     * @param input      La clase RatingInput con los detalles de la puntuación.
     * @param errors     Interfaz de errores de Spring.
     * @return Devuelve un JSON con la respuesta RatingOutput.
     * @see RatingOutput
     */
    @PostMapping("/ajax/rating-product")
    public ResponseEntity<?> addUserRating(@AuthenticationPrincipal UserDetails activeUser, @Valid @RequestBody RatingInput input, Errors errors) {
        RatingOutput output = new RatingOutput();
        ResponseEntity<?> response = checkErrors(activeUser, errors, output);
        if (response != null) return response;
        User user = userService.findByUsername(activeUser.getUsername());
        Product product = this.productService.getProduct(input.getProductId());
        RatingValue ratingValue = this.ratingValueService.getOne((long) input.getCount());
        this.ratingService.setProductRating(user, product, ratingValue);
        //TODO Product no actualiza su lista de Rating hasta la siguiente petición
        output.setAverageRating(product.getAverageRating());
        output.setRatingPercent(product.getRatingPercent());
        output.setMessage("Se ha valorado correctamente.");
        return ResponseEntity.ok(output);
    }

    /**
     * Obtiene el carrito actual del usuario.
     *
     * @param activeUser El usuario activo.
     * @return Devuelve un JSON con la respuesta UserCartOutput.
     */
    @PostMapping("/ajax/current-cart")
    public ResponseEntity<?> getUserCurrentCart(@AuthenticationPrincipal UserDetails activeUser) {
        UserCartOutput output = new UserCartOutput();
        if (activeUser != null) {
            User user = userService.findByUsername(activeUser.getUsername());
            output.setTotalProducts((int) cartService.totalProducts(user));
            output.setMessage("Petición correcta.");
            return ResponseEntity.ok(output);
        } else {
            output.setTotalProducts(0);
            output.setMessage("Petición correcta.");
            return ResponseEntity.ok(output);
        }

    }

    /**
     * Añade un producto al carrito.
     *
     * @param activeUser El usuario activo.
     * @param input      La clase AddCartInput con los detalles de lo que va a añadirse.
     * @param errors     Interfaz de errores de Spring.
     * @return Devuelve un JSON con la respuesta AddToCartOutput.
     * @see AddCartInput
     */
    @PostMapping("/ajax/add-cart")
    public ResponseEntity<?> addToUserCart(@AuthenticationPrincipal UserDetails activeUser, @Valid @RequestBody AddCartInput input, Errors errors) {
        AddToCartOutput output = new AddToCartOutput();
        ResponseEntity<?> response = checkErrors(activeUser, errors, output);
        if (response != null) return response;
        Product product = this.productService.getProduct(input.getProductId());
        User user = userService.findByUsername(activeUser.getUsername());
        Cart cart = new Cart(input.getCount(), product, user);
        cartService.add(cart);
        output.setTotalProducts((int) cartService.totalProducts(user));
        output.setMessage("Se ha añadido correctamente al carrito.");
        return ResponseEntity.ok(output);
    }

    /**
     * Método que actualiza el carrito del usuario.
     *
     * @param activeUser El usuario activo.
     * @param input      La clase UpdateCartInput con los detalles del carrito.
     * @param errors     Interfaz de errores de Spring.
     * @return Devuelve un JSON con la respuesta UpdateCartOutput.
     */
    @PostMapping("/ajax/update-cart")
    public ResponseEntity<?> updateUserCart(@AuthenticationPrincipal UserDetails activeUser, @Valid @RequestBody UpdateCartInput input, Errors errors) {
        UpdateCartOutput output = new UpdateCartOutput();
        ResponseEntity<?> response = checkErrors(activeUser, errors, output);
        if (response != null) return response;
        long id = (long) input.getCartId();
        Cart cart = this.cartService.get(id);
        cart.setCount(input.getCount());
        this.cartService.save(cart);
        output.setMessage("Se ha modificado la cantidad.");
        return ResponseEntity.ok(output);
    }

    /**
     * Método que elimina una entrada del carrito del usuario conectado.
     *
     * @param activeUser El usuario activo.
     * @param input      La clase UpdateCartInput con los detalles de lo que va a eliminarse.
     * @param errors     Interfaz de errores de Spring.
     * @return Devuelve un JSON con la respuesta UpdateCartOutput.
     * @see UpdateCartInput
     */
    @PostMapping("/ajax/remove-cart")
    public ResponseEntity<?> removeCartViaAjax(
            @AuthenticationPrincipal UserDetails activeUser,
            @Valid @RequestBody UpdateCartInput input,
            Errors errors
    ) {
        UpdateCartOutput output = new UpdateCartOutput();
        ResponseEntity<?> response = checkErrors(activeUser, errors, output);
        if (response != null) return response;
        Cart cart = this.cartService.get(input.getCartId());
        cartService.removeCart(cart);
        output.setMessage("Se ha eliminado correctamente del carrito.");
        return ResponseEntity.ok(output);
    }

}