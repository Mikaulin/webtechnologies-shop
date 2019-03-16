package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


public class Rating {
    @Id
    @ManyToOne
    @JoinColumn(name="ID_USER")
    private User user;
    @Id
    @ManyToOne
    @JoinColumn(name="ID_PRODUCT")
    private Product product;
    private int value;

    public Rating(){}

    public Rating(User user, Product product, int value) {
        this.user = user;
        this.product = product;
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "user=" + user +
                ", product=" + product +
                ", value=" + value +
                '}';
    }
}
