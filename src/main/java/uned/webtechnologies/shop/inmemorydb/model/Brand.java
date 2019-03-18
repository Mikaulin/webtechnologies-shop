package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Brand {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany(mappedBy = "brand")

    private Set<Product> products=new HashSet<>();


    public Brand (){}

    public Brand(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


