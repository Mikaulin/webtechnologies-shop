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

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = NumberUtils.roundDecimals(unitPrice);
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = NumberUtils.roundDecimals(purchasePrice);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

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
