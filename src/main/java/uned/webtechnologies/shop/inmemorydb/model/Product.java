package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.*;


@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String photo;
    private int count;
    private double price;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BRAND")
    private Brand brand;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CATEGORY")
    private Category category;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_DETAILS")
    private ProductDetails details;
    private double desc;


    public Product() {
    }



    public Product(String name, String photo, int count, Brand brand, Category category, ProductDetails details, double desc, double price) {

        this.name = name;
        this.photo = photo;
        this.count = count;
        this.brand = brand;
        this.category = category;
        this.details = details;
        this.desc = desc;
        this.price = price;

    }


    public void setDetails(ProductDetails details) {
        this.details = details;
    }

    public ProductDetails getDetails() {
        return details;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getDesc() {
        return desc;
    }

    public void setDesc(double desc) {
        this.desc = desc;
    }

    public double getPriceDesc() {
        return price + price * (desc / 100);
    }

    public int getId() {
        return id;
    }

    public double getDif() {
        return price*(desc/100);
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", brand=" + brand +
                ", category=" + category +
                ", details=" + details +
                ", desc=" + desc +
                '}';
    }
}
