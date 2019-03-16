package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
public class PurchaseLine {

    @Id
    @GeneratedValue
    private int id;
    private Date date;
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
        date=new Date();
        this.unitPrice = cart.getProduct().getFinalPrice();
        this.purchasePrice = cart.getPurchasePrice();
        this.count = cart.getCount();
        this.product=cart.getProduct();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
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
                '}';
    }
}
