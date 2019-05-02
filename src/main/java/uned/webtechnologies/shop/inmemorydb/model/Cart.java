package uned.webtechnologies.shop.inmemorydb.model;

import uned.webtechnologies.shop.utils.NumberUtils;

import javax.persistence.*;

/**
 * <P>Esta clase Método que define una linea de carro de compra.</P>
 * Una linea de compra debe pertenecer a un Usuario y contiene la información del producto que desea comprar y la cantidad de unidades por linea.
 *
 * @see Product
 * @see User
 */

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private long id;
    private int count;
    @ManyToOne
    @JoinColumn(name = "ID_PRODUCT")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private User user;
    private double unitPrice;
    @Transient
    private double cartPrice;

    @PrePersist
    @PostPersist
    @PostLoad
    @PostUpdate
    private void calculatePrices() {


        setUnitPrice(getProduct().getFinalPrice());
        setCartPrice(NumberUtils.roundDecimals(getUnitPrice() * getCount()));

    }

    public Cart() {
    }


    public Cart(int count, Product product, User user) {
        this.count = count;
        this.product = product;
        this.user = user;
    }


    /**
     * Método que define el identificador único del Cart
     *
     * @param id identificador único de tipo long
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Método que devuelve el precio unitario del producto que se desea comprar
     *
     * @return precio unitario del producto que se desea comprar
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Método que define el precio unitario del producto redondeado.
     *
     * @param unitPrice Precio unitario del producto.
     * @see NumberUtils#roundDecimals(double)
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = NumberUtils.roundDecimals(unitPrice);
    }

    /**
     * Método que devuelve el precio total de la compra.
     *
     * @return Precio double total de la compra calculado a partir del precio unitario múltiplicado por la cantidad de productos a comprar
     */
    public double getCartPrice() {
        return cartPrice;
    }

    /**
     * Método que define el precio total de la compra
     *
     * @param cartPrice Precio total de la compra
     * @see NumberUtils#roundDecimals(double)
     */
    public void setCartPrice(double cartPrice) {
        this.cartPrice = NumberUtils.roundDecimals(cartPrice);
    }

    /**
     * Método que devuelve el identificador único de la compra
     *
     * @return Identificador long único del Cart
     */
    public long getId() {
        return id;
    }

    /**
     * Método que devuelve el Usuario que quiere realizar la compra
     *
     * @return El usuario User que quiere realizar la compra
     * @see User
     */
    public User getUser() {
        return user;
    }

    /**
     * Método que define el usuario que quiere realizar la compra
     *
     * @param user El usuario que quiere realizar la compra
     * @see User
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Método que devuelve la cantidad de productos a comprar
     *
     * @return La cantidad int de productos a comprar
     */
    public int getCount() {
        return count;
    }

    /**
     * Método que define la cantidad de productos a comprar
     *
     * @param count La cantidad de productos a comprar
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Método que devuelve el producto que se desea comprar
     *
     * @return El producto Product que se desea comprar
     * @see Product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Método que define el producto que se desea comprar
     *
     * @param product El producto que se quiere comprar
     * @see Product
     */
    public void setProduct(Product product) {
        this.product = product;
    }


    /**
     * Método que devuelve una representacion en texto de la linea de carrito
     *
     * @return La representación String de la linea de carrito
     */
    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", count=" + count +
                ", product=" + product +
                ", user=" + user +
                '}';
    }
}
