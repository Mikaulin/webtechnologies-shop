package uned.webtechnologies.shop.inmemorydb.model;

import org.springframework.format.annotation.DateTimeFormat;
import uned.webtechnologies.shop.utils.NumberUtils;

import javax.persistence.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Entity
public class PurchaseLine {

    @Id
    @GeneratedValue
    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Calendar date;
    private double unitPrice;
    private double purchasePrice;
    private int count;
    @ManyToOne
    @JoinColumn(name="ID_PRODUCT")
    private Product product;
    @ManyToOne
    @JoinColumn(name="ID_USER")
    private User user;

    public PurchaseLine(){}

    public PurchaseLine(Cart cart) {
        date = new GregorianCalendar();
        this.count = cart.getCount();
        this.product = cart.getProduct();
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**Define el identificador único de la linea de compra
     * @param id identificador único de la linea de compra
     */
    public void setId(long id) {
        this.id = id;
    }

    /**Define el usuario que ha realizado la compra
     * @param user Usuario que realiza la compra
     * @see User
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**Devuelve el identificador único de la linea de compra
     * @return long con el identificador único de la linea de compra
     */
    public long getId() {
        return id;
    }

    /**Devuelve el usuario que ha realizado la compra
     * @return User usuario que ha realizado la compra
     * @see User
     */
    public User getUser() {
        return user;
    }

    /**Devuelve un objeto Calendar que contiene la fecha de realización de la compra
     * @return Calendar que contiene la fecha de realización de la compra
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html">Calendar</a>
     */
    public Calendar getDate() {
        return date;
    }

    /**Define la fecha de la compra
     * @param date Calendar que contiene la fecha de la realización de la compra
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html">Calendar</a>
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**Devuelve el precio unitario del producto que se compra
     * @return double con el precio únitario del producto que se compra
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**Define el precio unitario del producto que se compra
     * @param unitPrice Precio unitario del producto que se compra
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = NumberUtils.roundDecimals(unitPrice);
    }

    /**Devuelve el precio total de la compra realizada
     * @return double con el precio total de la compra realizada
     */
    public double getPurchasePrice() {
        return purchasePrice;
    }

    /**Define el precio total de la compra realizada
     * @param purchasePrice Precio total de la compra realizada
     */
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = NumberUtils.roundDecimals(purchasePrice);
    }

    /**Devuelve la cantidad de productos incluidos en la compra realizada
     * @return Entero con la cantidad de productos incluidos en la compra realizada
     */
    public int getCount() {
        return count;
    }

    /**Define la cantidad de productos que incluidos en la compra
     * @param count Cantidad de productos incluidos en la compra
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**Devuelve el producto que se compra
     * @return Producto que se compra.
     * @see Product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Define el producto comprado
     * @param product Producto comprado
     * @see Product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**Devuelve una cadena que representa la compra realizada.
     * @return Cadena que representa la compra realizada.
     */
    @Override
    public String toString() {
        return "PurchaseLine{" +
                "id=" + id +
                ", date=" + date +
                ", unitPrice=" + unitPrice +
                ", purchasePrice=" + purchasePrice +
                ", count=" + count +
                ", product=" + product +
                ", user=" + user +
                '}';
    }
}
