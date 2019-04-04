package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Cart;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.repository.CartRepository;
import uned.webtechnologies.shop.utils.NumberUtils;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public void add(Cart cart) {
        List<Cart> cartList = cartRepository.findByUserAndProduct(cart.getUser(), cart.getProduct());
        if(!cartList.isEmpty()) {
            int totalUnits = cart.getCount();
            for (Cart currentCart : cartList) {
                totalUnits += currentCart.getCount();
            }
            cart.setCount(totalUnits);
            cartRepository.delete(cartList);
        }
        this.cartRepository.save(cart);
    }

    public long totalProducts(User user) {
        return this.cartRepository.sumUserCartUnits(user.getId());
    }

    public double userSubtotal (User user){

        double subTotal = NumberUtils.roundDecimals(userTotal (user) - (userTotal (user)* 0.21));

        return subTotal;
    }

    public double userIVA (User user){

        double iva = NumberUtils.roundDecimals(userTotal (user)* 0.21);

        return iva;
    }

    public double usertotalPrice(User user) {
        return this.userTotal(user);
    }

    public double userTotal(User user){
        List<Cart> carts=this.cartRepository.findByUser(user);
        double total = 0;
        for (Cart cart:carts) {
            total= NumberUtils.roundDecimals(total+cart.getCount()*cart.getProduct().getFinalPrice());
        }
        return total;
    }

    public void removeCart(Cart cart){
        this.cartRepository.delete(cart.getId());}

    public void removeAllOfUser(User user){
        List<Cart> carts=this.cartRepository.findByUser(user);
        for (Cart cart:carts
        ) {this.cartRepository.delete(cart);

        }

    }


    public List<Cart> findByUser(User user) {
        return this.cartRepository.findByUser(user);
    }
}
