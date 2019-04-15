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

import uned.webtechnologies.shop.controllers.input.UpdateCartInput;
import uned.webtechnologies.shop.controllers.output.AddToCartOutput;

import uned.webtechnologies.shop.controllers.output.UpdateCartOutput;
import uned.webtechnologies.shop.inmemorydb.model.Cart;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.services.CartService;
import uned.webtechnologies.shop.services.ProductService;
import uned.webtechnologies.shop.services.UserService;
import uned.webtechnologies.shop.utils.StringUtils;

import javax.validation.Valid;

@RestController
public class AjaxController {
    private UserService userService;
    private CartService cartService;
    private ProductService productService;

    @Autowired
    public AjaxController(CartService cartService, ProductService productService, UserService userService) {
        this.cartService = cartService;
        this.productService = productService;
        this.userService = userService;
    }

    @PostMapping("/ajax/add-cart")
    public ResponseEntity<?> getSearchResultViaAjax(@AuthenticationPrincipal UserDetails activeUser, @Valid @RequestBody AddCartInput input, Errors errors) {

        AddToCartOutput output = new AddToCartOutput();

        if (errors.hasErrors()) {
            output.setMessage(StringUtils.getStringFromErrors(errors));
            return ResponseEntity.badRequest().body(output);
        } else if (activeUser == null) {
            output.setMessage("No te has conectado.");
            return ResponseEntity.badRequest().body(output);
        }
        User user = userService.findByUsername(activeUser.getUsername());
        Product product = this.productService.getProduct(input.getProductId());
        Cart cart = new Cart(input.getCount(), product, user);
        cartService.add(cart);
        output.setTotalProducts((int) cartService.totalProducts(user));
        output.setMessage("Se ha añadido correctamente al carrito.");
        return ResponseEntity.ok(output);

    }

    @PostMapping("/ajax/update-cart")
    public ResponseEntity<?> getSearchResultViaAjax(@AuthenticationPrincipal UserDetails activeUser, @Valid @RequestBody UpdateCartInput input, Errors errors) {

        UpdateCartOutput output = new UpdateCartOutput();

        if (errors.hasErrors()) {
            output.setMessage(StringUtils.getStringFromErrors(errors));
            return ResponseEntity.badRequest().body(output);
        } else if (activeUser == null) {
            output.setMessage("No te has conectado.");
            return ResponseEntity.badRequest().body(output);
        }
        User user = userService.findByUsername(activeUser.getUsername());
        int count = input.getCount();
        long id = (long) input.getCartId();
        Cart cart = this.cartService.get(id);

        cart.setCount(input.getCount());
        this.cartService.save(cart);
        output.setMessage("Se ha modificado la cantidad.");
        return ResponseEntity.ok(output);

    }

  /*  @PostMapping("/ajax/remove-cart")
  public ResponseEntity<?> getSearchResultViaAjax(@AuthenticationPrincipal UserDetails activeUser, @Valid @RequestBody RemoveCartInput input, Errors errors) {

        RemoveCartOutput output = new RemoveCartOutput();

        if (errors.hasErrors()) {
            output.setMessage(StringUtils.getStringFromErrors(errors));
            return ResponseEntity.badRequest().body(output);
        } else if(activeUser == null) {
            output.setMessage("No te has conectado.");
            return ResponseEntity.badRequest().body(output);
        }
        User user = userService.findByUsername(activeUser.getUsername());
        Product product = this.productService.getProduct(input.getProductId());
        List<Cart> carts = this.cartService.get(user,product);
        for (Cart cart: carts
             ) {
            cartService.removeCart(cart);

        }


        output.setMessage("Se ha eliminado correctamente del carrito.");

        return ResponseEntity.ok(output);


    }*/


}
