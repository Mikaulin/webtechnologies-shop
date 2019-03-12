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
    private int level;
    @OneToOne(cascade={CascadeType.DETACH})
    @JoinColumn(name="ID_PARENT")
    private Category categoryParent;

    @OneToMany(mappedBy = "category")

    private Set<Product> products=new HashSet<>();


    public Category(){}
    public Category(String name){

    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Category(String name, Category parent) {

        this.name = name;
        if (parent==null){
            this.level=0;
            this.categoryParent=null;

        }else{
               this.level=parent.getLevel()+1;
               this.categoryParent=parent;

        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Category getCategoryParent() {
        return categoryParent;
    }

    public void setCategoryParent(Category categoryParent) {
        this.categoryParent = categoryParent;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", categoryParent=" + categoryParent +
                '}';
    }
}
