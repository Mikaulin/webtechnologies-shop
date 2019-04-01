package uned.webtechnologies.shop.inmemorydb.model;

import uned.webtechnologies.shop.utils.NumberUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


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

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Promotion> promotions;

    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "productId")
    private List<Rating> ratingList;

    @Transient
    private double averageRating;

    @Transient
    private double ratingPercent;

    @PostLoad
    private void postLoad() {
        Integer sum = 0;
        if (!ratingList.isEmpty()) {
            for (Rating rating : ratingList) {
                sum += rating.getRatingValue().getValue();
            }
            this.averageRating = sum.doubleValue() / ratingList.size();
        } else {
            this.averageRating = 0;
        }
        //TODO Las constantes se deberían sacar a algún archivo de constanets
        this.ratingPercent = this.averageRating / 5 * 100;
    }

    public Product() {
        promotions = new HashSet<>();
    }

    public void setId(long id) {
        this.id = id;
    }


    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }

    /**
     * @param count       Numero de unidades disponibles
     * @param name
     * @param description
     * @param photo
     * @param price
     * @param height
     * @param width
     * @param depth
     * @param deleted
     * @param brand
     * @param category
     */
    public Product(int count, String name, String description, String photo, double price, double height, double width, double depth, boolean deleted, boolean featured, Brand brand, Category category) {
        promotions = new HashSet<>();
        this.count = count;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.price = price;

        this.height = height;
        this.width = width;
        this.depth = depth;
        this.deleted = deleted;
        this.brand = brand;
        this.category = category;
        this.featured = featured;
    }

    public Product(int count, String name, String description, String photo, double price, double height, double width, double depth, boolean featured, Brand brand, Category category) {
        promotions = new HashSet<>();
        this.count = count;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.price = price;
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


    public void setPromotion(Promotion promo) {
        if (promotions == null) {
            Set<Promotion> promos = new HashSet<Promotion>();
            promos.add(promo);

            setPromotions(promos);
        } else {
            this.promotions.add(promo);
        }
    }

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

    public double getDiscount() {
        double discount = 0;

        if (promotions != null) {
            Calendar today = new GregorianCalendar();
            today.setTime(new Date());
            for (Promotion promo : this.promotions) {
                if ((today.after(promo.getStartDate())) && (today.before(promo.getEndDate()))) {
                    if (promo.getDiscount() > discount) {
                        discount = promo.getDiscount();
                    }
                }
            }
        }
        return discount;
    }

    public double getFinalPrice() {
        return  NumberUtils.roundDecimals(this.price - (price * (getDiscount() / 100)));
    }

    public double getDif() {
        return this.price - getFinalPrice();
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

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    @Transient
    public double getAverageRating() {
        return averageRating;
    }

    @Transient
    public double getRatingPercent() {
        return ratingPercent;
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
                ", height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                ", featured=" + featured +
                ", deleted=" + deleted +
                ", brand=" + brand.getName() +
                ", category=" + category.getName() +
                ", rating=" +
                '}';
    }
}
