package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private long id;
    private int count;
    @Transient
    private double purchasePrice;
    @ManyToOne
    @JoinColumn(name="ID_PRODUCT")
    private Product product;
    @ManyToOne
    @JoinColumn(name="ID_USER")
    private User user;

    public Cart(){}

    public Cart(int count, Product product,User user) {
        this.count = count;
        this.product = product;
        this.user=user;
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

    public double getPurchasePrice() {
        return count * product.getFinalPrice();
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
