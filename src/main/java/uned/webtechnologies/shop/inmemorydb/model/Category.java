package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Método que define una categoría de producto.
 *
 * @see Product
 */

@Entity
public class Category {


    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<>();

    /**
     * Método que define el identificador único de la categoría
     *
     * @param id identificador único de la categoría
     */
    public void setId(long id) {
        this.id = id;
    }

    public Category() {
    }

    /**
     * Construye una categoría con un nombre
     *
     * @param name Nombre de la categoría
     */
    public Category(String name) {
        this.name = name;
    }

    /**
     * Método que devuelve el identificador único de la categoría
     *
     * @return Identificador único long de la categoría
     */
    public long getId() {
        return id;
    }

    /**
     * Método que devuelve el nombre de la categoría
     *
     * @return String con el nombre de la categoría
     */
    public String getName() {
        return name;
    }

    /**
     * Método que define el nombre de la categoría
     *
     * @param name Nombre de la categoría
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método que devuelve un conjunto  "Set" que contiene todos los productos que pertenecen a la categoría
     *
     * @return Conjunto "Set" de productos que pertenecesn a la categoría
     * @see Product
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * Método que añade un conjunto de productos a la categoría
     *
     * @param products Conjunto de productos que se quieren incluir en la categoría.
     * @see Product
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }


    /**
     * Método que devuelve la representación en texto de la categoría
     *
     * @return Una cadena que representa la categoría
     */
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
