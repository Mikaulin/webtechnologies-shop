package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Cart;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.repository.CartRepository;

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
    public double userTotal(User user){
        List<Cart> carts=this.cartRepository.findByUser(user);
        double total=0;
        for (Cart cart:carts
             ) {total=total+cart.getCount()*cart.getProduct().getFinalPrice();


        }
        return total;
    }


    public List<Cart> findByUser(User user) {
        return this.cartRepository.findByUser(user);
    }
}
