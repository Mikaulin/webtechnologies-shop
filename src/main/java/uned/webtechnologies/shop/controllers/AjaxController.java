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
import uned.webtechnologies.shop.controllers.output.AddToCartOutput;
import uned.webtechnologies.shop.controllers.output.Output;
import uned.webtechnologies.shop.controllers.output.RatingOutput;
import uned.webtechnologies.shop.controllers.output.UpdateCartOutput;
import uned.webtechnologies.shop.inmemorydb.model.Cart;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.RatingValue;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.repository.RatingValueRepository;
import uned.webtechnologies.shop.services.*;

import uned.webtechnologies.shop.utils.StringUtils;

import javax.validation.Valid;


@RestController
public class AjaxController {
    private UserService userService;
    private CartService cartService;
    private ProductService productService;
    private RatingService ratingService;
    private RatingValueService ratingValueService;

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

    @PostMapping("/ajax/rating-product")
    public ResponseEntity<?> getSearchResultViaAjax(@AuthenticationPrincipal UserDetails activeUser, @Valid @RequestBody RatingInput input, Errors errors) {
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

    @PostMapping("/ajax/add-cart")
    public ResponseEntity<?> getSearchResultViaAjax(@AuthenticationPrincipal UserDetails activeUser, @Valid @RequestBody AddCartInput input, Errors errors) {
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


    @PostMapping("/ajax/update-cart")
    public ResponseEntity<?> getSearchResultViaAjax(@AuthenticationPrincipal UserDetails activeUser, @Valid @RequestBody UpdateCartInput input, Errors errors) {
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