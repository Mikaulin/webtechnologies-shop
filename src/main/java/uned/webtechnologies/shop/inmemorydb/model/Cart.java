package uned.webtechnologies.shop.inmemorydb.model;

import uned.webtechnologies.shop.utils.NumberUtils;

import javax.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private long id;
    private int count;
    @ManyToOne
    @JoinColumn(name="ID_PRODUCT")
    private Product product;
    @ManyToOne
    @JoinColumn(name="ID_USER")
    private User user;
    private double unitPrice;
    @Transient
    private double cartPrice;

    @PrePersist
    @PostPersist
    @PostLoad
    @PostUpdate
    private void calculatePrices(){


        setUnitPrice(getProduct().getFinalPrice());
        setCartPrice(NumberUtils.roundDecimals(getUnitPrice()*getCount()));

    }

    public Cart(){}



    public Cart(int count, Product product, User user) {
        this.count = count;
        this.product = product;
        this.user=user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = NumberUtils.roundDecimals(unitPrice);
    }

    public double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(double cartPrice) {
        this.cartPrice = NumberUtils.roundDecimals(cartPrice);
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return "Cart{" +
                "id=" + id +
                ", count=" + count +
                ", product=" + product +
                ", user=" + user +
                '}';
    }
}
