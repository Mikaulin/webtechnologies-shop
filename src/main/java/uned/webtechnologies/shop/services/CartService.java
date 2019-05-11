package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Cart;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.repository.CartRepository;
import uned.webtechnologies.shop.utils.NumberUtils;

import java.io.Serializable;
import java.util.List;

/**Servicio que implementa la lógica de negócio del MVC entre el controlador y las Lineas de carrito del modelo
 * @see Cart
 * @see CartRepository
 */
@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    /**
     * Método que se encarga de añadir una linea de carrito (Cart) al repositorio evitando que existan para un mismo usuario diferentes Carts con el mismo producto
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

    /**
     * Método que guarda un Cart en el repositorio de Carts.
     *
     * @param cart Linea de carrito que se quiere guardar.
     * @see Cart
     * @see CartRepository
     */
    public void save(Cart cart) {
        this.cartRepository.save(cart);
    }


    /**
     * Método que devuelve la cantidad total de productos existentes en los Carts de un usuario
     *
     * @param user Usuario sobre el que se desea obtener el sumatorio de productos existentes en sus Carts
     * @return Sumatorio de productos existentes en los Carts de un usuario concreto
     * @see CartRepository Repositorio de lines de Carrito "Cart"
     * @see User Usuario sobre del que se obtiene el sumatorio de productos en el carrito
     */
    public long totalProducts(User user) {
        if (this.cartRepository.countByUser(user) > 0) {
            return this.cartRepository.sumUserCartUnits(user.getId());
        } else
            return 0;
    }


    /**Método que devuelve la coste total de las lineas de  carrito de la compra descontando un supuesto I.V.A aplicado del 21%
     * @param user Usuario del que se obtiene el subtotal del carrito de compra
     * @return coste total de las lineas de  carrito de la compra descontando un supuesto I.V.A aplicado del 21%
     */
    public double userSubtotal(User user) {
        return NumberUtils.roundDecimals(userTotal(user) /1.21);
    }


    /**Método que devuelve sumatorio el coste de un supuesto I.V.A del 21% aplicado a todos las lineas de carrito de un usuario
     * @param user Usuario sobre el que se obtiene el I.V.A del 21%
     * @return sumatorio el coste de un supuesto I.V.A del 21% aplicado a todos las lineas de carrito de un usuario
     */
    public double userIVA(User user) {

        double iva = NumberUtils.roundDecimals(userSubtotal(user) * 0.21);

        return iva;
    }


    /**Método que devuelve el coste del sumatorio de las lineas de carrito del usuario
     * @param user Usuario sobre el que se quiere obtener el total
     * @return coste del sumatorio de las lineas de carrito del usuario
     * @see CartRepository#findByUser(User)
     */
    public double userTotal(User user) {
        List<Cart> carts = this.cartRepository.findByUser(user);
        double total = 0;
        for (Cart cart : carts) {
            total = NumberUtils.roundDecimals(total + cart.getCartPrice());
        }
        return total;
    }

    /**Método que devuelve una linea de carro concreta del repositorio de lineas de carrito
     * @param id Identificador único de la linea de carrito que se desea
     * @return Linea de carrito "Cart"
     * @see CartRepository#findOne(Serializable)
     */
    public Cart get(long id) {
        return this.cartRepository.findOne(id);
    }

    /**Método que borra una linea de carrito del repositorio de lineas de carrito
     * @param cart Linea de carrito que se desea borrar
     * @see CartRepository#delete(Serializable)
     */
    public void removeCart(Cart cart) {
        this.cartRepository.delete(cart.getId());
    }

    /**<P>Método que borra todas las lineas de carrito de un usuario.</P>
     * <p>Pensado prinipalmente para ser llamado tras formalizar la compra</p>
     *
     * @param user  Usuario del que borrar las lineas de carrito.
     * @see CartRepository#delete(Object)
     */
    public void removeAllOfUser(User user) {
        List<Cart> carts = this.cartRepository.findByUser(user);
        for (Cart cart : carts
        ) {
            this.cartRepository.delete(cart);
        }
    }

    /**Método que devuelve todas las lineas de carrito de un usuario
     * @param user Usuario del que obtener la lista de lineas de carrito
     * @return Lista de lineas de carrito de un usuario
     * @see CartRepository#findByUser(User)
     */
    public List<Cart> findByUser(User user) {
        return this.cartRepository.findByUser(user);
    }
}
