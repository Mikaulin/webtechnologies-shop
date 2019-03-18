package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {


    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany (mappedBy = "category")
    private Set<Product> products=new HashSet<>();
    public Category(){}

    public Category(String name) {
        this.name = name;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
