package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Esta clase define un objeto de tipo Marca.
 * Una Marca contiene objetos de tipo Producto.
 *
 * @see Product
 */


@Entity
public class Brand {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(mappedBy = "brand")

    private Set<Product> products = new HashSet<>();

    /**
     * Define el identificador único de la marca
     *
     * @param id Identificador único de la entidad.
     */
    public void setId(long id) {
        this.id = id;
    }


    public Brand() {
    }

    /**
     * Construye una categoria con un nombre
     *
     * @param name Nombre de la categoría
     */
    public Brand(String name) {
        this.name = name;
    }

    /**
     * Devuelve un conjunto de productos que pertenecen a esta categoría
     *
     * @return Conjunto "Set" de productos que pertenecen a esta categoría
     * @see Product
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * Añade un conjunto de productos a esta categoría
     *
     * @param products Conjunto de productos que se quieren asignar a esta categoría
     * @see Product
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }


    /**
     * Devuelve el nombre de la categoría
     *
     * @return Nombre de la categoría
     */
    public String getName() {
        return name;
    }


    /**
     * Define el nombre de la categoría
     *
     * @param name Nombre de la categoría
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Identificador único de la categoría
     *
     * @return Id "identificador único de la categoría"
     */
    public long getId() {
        return id;
    }


    /**
     * Devuelve una representacion en texto de la marca
     *
     * @return String que representa el estado de la categoría
     */
    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


