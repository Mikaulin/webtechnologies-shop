package uned.webtechnologies.shop.inmemorydb.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

/**
 * Clase que define una promocion.
 * Las promociones sirven para ser asignadas a determinados productos y consisten en porcentajes de descuento sobre el precio del producto.
 * Las promociones estarán activas unicamente dentro del periodo comprendido entre la fecha de inicio y la fecha fin.
 *
 * @see Product
 */
@Entity
public class Promotion {

    @Id
    @GeneratedValue
    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar endDate;
    private String name;
    private String description;
    private int discount;
    @ManyToMany(mappedBy = "promotions", fetch = FetchType.EAGER)
    private Set<Product> products = new HashSet<>();

    @Transient
    private boolean active;

    /**
     * Metodo que se ejecuta en el momento de persistir el objeto en la BBDD.
     * La  promocion solo estará activa mientras la fecha actual este comprendida entre las fechas de inicio y fin.
     * El metodo de definición como activa o inactiva se ejecuta de forma automática.
     */
    @PostLoad
    private void postLoad() {
        Date today = new Date();
        today.getTime();
        if ((today.after(startDate.getTime())) && (today.before(endDate.getTime()))) {
            this.setActive(true);
        } else if ((today.before(startDate.getTime())) && (today.before(endDate.getTime()))) {
            this.setActive(true);
        } else {
            this.setActive(false);
        }

    }

    /**
     * Devuelve el estado (activo- inactivo) de la promoción
     *
     * @return booleano con es estado (activo-inactivo) de la promoción
     */
    @Transient
    public boolean isActive() {
        return active;
    }

    /**
     * Define la promoción como activa o inactiva.
     * <p>
     * Este metodo se ejecuta automaticamente al persistir o recuperar el objeto de la bbdd
     *
     * @param active booleano con el estado (activa-inactiva) de la promoción
     */
    @Transient
    private void setActive(boolean active) {
        this.active = active;
    }

    public Promotion() {
    }

    /**
     * Devuelve el identificador único de la promoción
     *
     * @param id double con el identificador único de la promoción
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Define el identificador único de la promoción-
     *
     * @return double con el identificador único de la promoción
     */
    public long getId() {
        return id;
    }

    /**
     * Devuelve un conjunto "Set" con los productos que pertenecen a la promoción
     *
     * @return Conjunto "Set" de productos que pertenecen a la promoción
     * @see Product
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * Devuelve una cadena con el nombre de la promoción
     *
     * @return Cadena con el nombre de la promoción
     */
    public String getName() {
        return name;
    }

    /**
     * Define el nombre de la promoción
     *
     * @param name Cadena con el nombre de la promoción
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Define los productos que tienen esta promoción asignada
     *
     * @param products conjunto "Set" de productos a los que se les quiere asignar esta promoción.
     * @see Product
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    /**
     * Devuelve el porcentaje de descuento  que aplica la promoción a los productos
     *
     * @return Entero con el porcentaje de descuento que aplica la promoción a los productos
     * @see Product
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * Define el porcentaje de descuento que debe aplicar la promoción a los productos
     *
     * @param discount Entero con el porcentaje que debe aplicar la promoción a los productos
     * @see Product
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }


    /**
     * Devuelve un objeto Calendar que contiene la fecha ("yyyy-MM-dd") de inicio de la promoción
     *
     * @return Calendar que contiene la fecha ("yyyy-MM-dd") de inicio de la promoción
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html">Calendar</a>
     */
    public Calendar getStartDate() {
        return startDate;
    }

    /**
     * Define la fecha de inicio de la promoción a partir de un objeto tipo Calendar que contenga la fecha en formato ("yyyy-MM-dd")
     *
     * @param startDate Calendar con la fecha de inicio de la promoción en formato ("yyyy-MM-dd")
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html">Calendar</a>
     */
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    /**
     * Devuelve un objeto Calendar que contiene la fecha ("yyyy-MM-dd") fin de la promoción
     *
     * @return Calendar que contiene la fecha ("yyyy-MM-dd") de finalización de la promoción
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html">Calendar</a>
     */
    public Calendar getEndDate() {
        return endDate;
    }

    /**
     * Define la fecha de finalización de la promoción a partir de un objeto tipo Calendar que contenga la fecha en formato ("yyyy-MM-dd")
     *
     * @param endDate Calendar con la fecha de finalización de la promoción en formato ("yyyy-MM-dd")
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html">Calendar</a>
     */
    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }


    /**
     * Devuelve una cadena de texto con la descripción de la promoción
     *
     * @return Cadena de texto con la descripción de la promoción
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define la descripción de la promoción
     *
     * @param description Cadena con la descripción de la promoción
     */
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

    /**
     * Devuelve una cadena que representa la promoción
     *
     * @return Cadena que representa la promoción
     */
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
