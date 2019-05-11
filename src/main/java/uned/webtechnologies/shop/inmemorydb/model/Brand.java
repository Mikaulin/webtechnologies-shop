package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Esta clase Método que define un objeto de tipo Marca.
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
     * Método que define el identificador único de la marca
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
     * Método que devuelve un conjunto de productos que pertenecen a esta categoría
     *
     * @return Conjunto "Set" de productos que pertenecen a esta categoría
     * @see Product
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * Metodo que añade un conjunto de productos a esta categoría
     *
     * @param products Conjunto de productos que se quieren asignar a esta categoría
     * @see Product
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }


    /**
     * Método que devuelve el nombre de la categoría
     *
     * @return Nombre de la categoría
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
     * Metodo que devuelve el identificador único de la categoría
     *
     * @return Id "identificador único de la categoría"
     */
    public long getId() {
        return id;
    }


    /**
     * Método que devuelve una representacion en texto de la marca
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


