package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private int count;
    private String name;
    private String description;
    private String photo;
    private double price;
    private double discount;
    private double height;
    private double width;
    private double depth;
    private boolean featured;
    private boolean deleted;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BRAND")
    private Brand brand;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CATEGORY")
    private Category category;




    public Product() {

    }

    /**
     * @param count Numero de unidades disponibles
     * @param name
     * @param description
     * @param photo
     * @param price
     * @param discount
     * @param height
     * @param width
     * @param depth
     * @param deleted
     * @param brand
     * @param category
     */
    public Product(int count, String name, String description, String photo, double price, double discount, double height, double width, double depth, boolean deleted, boolean featured, Brand brand, Category category) {
        this.count = count;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.price = price;
        this.discount = discount;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.deleted = deleted;
        this.brand = brand;
        this.category = category;
        this.featured = featured;
    }

    public Product(int count, String name, String description, String photo, double price, double discount, double height, double width, double depth, boolean featured, Brand brand, Category category) {
        this.count = count;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.price = price;
        this.discount = discount;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.brand = brand;
        this.category = category;
        this.featured = featured;
        this.deleted = false;
    }



    public long getId() {
        return id;
    }

    /**
     * @return
     */
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double descount) {
        this.discount = descount;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getDif(){
        return getPrice()-getFinalPrice();
    }

    public double getFinalPrice(){
        return price-price*(discount/100);
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", count=" + count +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                ", featured=" + featured +
                ", deleted=" + deleted +
                ", brand=" + brand +
                ", category=" + category +
                ", rating=" +
                '}';
    }
}
