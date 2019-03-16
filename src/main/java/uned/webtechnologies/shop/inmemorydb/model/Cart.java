package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private int id;
    private int count;
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
        this.purchasePrice=calculatePurchasePrice();
        this.user=user;
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
        this.purchasePrice=calculatePurchasePrice();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.purchasePrice=calculatePurchasePrice();
    }
    private double calculatePurchasePrice(){
        double value;
        value=this.count*product.getFinalPrice();
        return value;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }



    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", count=" + count +
                ", purchasePrice=" + purchasePrice +
                ", product=" + product +
                ", user=" + user +
                '}';
    }
}
