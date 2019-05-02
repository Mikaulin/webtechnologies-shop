package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Cart;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.repository.CartRepository;
import uned.webtechnologies.shop.utils.NumberUtils;

import java.util.List;

/**
 * @see Cart
 * @see CartRepository
 */
@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    /**Método que se encarga de añadir una linea de carrito (Cart) al repositorio evitando que existan para un mismo usuario diferentes Carts con el mismo producto
     *
     * @param cart Linea de carrito que se quiere añadir al repositorio
     * @see Cart
     * @see uned.webtechnologies.shop.inmemorydb.repository.CategoryRepository
     * @see Product
     */
    public void add(Cart cart) {
        List<Cart> cartList = cartRepository.findByUserAndProduct(cart.getUser(), cart.getProduct());
        if (!cartList.isEmpty()) {
            int totalUnits = cart.getCount();
            for (Cart currentCart : cartList) {
                totalUnits += currentCart.getCount();
            }
            cart.setCount(totalUnits);
            cartRepository.delete(cartList);
        }
        this.cartRepository.save(cart);
    }

    /**Método que guarda un Cart en el repositorio de Carts.
     * @param cart Linea de carrito que se quiere guardar.
     * @see Cart
     * @see CartRepository
     */
    public void save(Cart cart) {
        this.cartRepository.save(cart);
    }


    /**Método que devuelve la cantidad total de productos existentes en los Carts de un usuario
     * @param user Usuario sobre el que se desea obtener el sumatorio de productos existentes en sus Carts
     * @return Sumatorio de productos existentes en los Carts de un usuario concreto
     * @see User
     */
    public long totalProducts(User user) {
        if(this.cartRepository.countByUser(user) > 0) {
            return this.cartRepository.sumUserCartUnits(user.getId());
        } else
            return 0;
    }


    public double userSubtotal(User user) {
        return NumberUtils.roundDecimals(userTotal(user) - (userTotal(user) * 0.21));
    }

    //TODO el IVA es un concepto que no se ha hablado. No debería calcularse aquí
    public double userIVA(User user) {

        double iva = NumberUtils.roundDecimals(userTotal(user) * 0.21);

        return iva;
    }


    public double userTotal(User user) {
        List<Cart> carts = this.cartRepository.findByUser(user);
        double total = 0;
        for (Cart cart : carts) {
            total = NumberUtils.roundDecimals(total + cart.getCartPrice());
        }
        return total;
    }

    public Cart get(long id) {
        return this.cartRepository.findOne(id);
    }

    public void removeCart(Cart cart) {
        this.cartRepository.delete(cart.getId());
    }

    public void removeAllOfUser(User user) {
        List<Cart> carts = this.cartRepository.findByUser(user);
        for (Cart cart : carts
        ) {
            this.cartRepository.delete(cart);
        }
    }

    public List<Cart> findByUser(User user) {
        return this.cartRepository.findByUser(user);
    }
}
