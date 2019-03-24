package uned.webtechnologies.shop.inmemorydb.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.*;

@Entity
public class Promotion {

    @Id
    @GeneratedValue
    private long id;
    private Calendar startDate;
    private Calendar endDate;
    private String name;
    private String description;
    private int discount;
    @ManyToMany (mappedBy = "promotions")
    private Set<Product> products=new HashSet<>();


    public Promotion(){}

    public Set<Product> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Promotion)) return false;
        Promotion promotion = (Promotion) o;
        return getId() == promotion.getId() &&
                getDiscount() == promotion.getDiscount() &&
                Objects.equals(getStartDate(), promotion.getStartDate()) &&
                Objects.equals(getEndDate(), promotion.getEndDate()) &&
                Objects.equals(getName(), promotion.getName()) &&
                Objects.equals(getDescription(), promotion.getDescription()) &&
                Objects.equals(getProducts(), promotion.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStartDate(), getEndDate(), getName(), getDescription(), getDiscount(), getProducts());
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", products=" + products +
                '}';
    }
}
