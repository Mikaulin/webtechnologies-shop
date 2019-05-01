package uned.webtechnologies.shop.inmemorydb.model;


import uned.webtechnologies.shop.inmemorydb.model.persistense.ProductUserRating;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Objects;

/**
 * Esta clase define una valoración de un usuario sobre un producto utilizando una clase ProductUserRating para establecer la relación entre el producto y el usuario.
 * Un usuario solo puede valorar una vez un producto con un objeto RatingValue
 * @see ProductUserRating
 * @see RatingValue
 * 
 */

@Entity
public class Rating {
    @EmbeddedId
    private ProductUserRating productUserRating;
    @OneToOne
    private RatingValue ratingValue;

    public Rating() {
        this.productUserRating = new ProductUserRating();

    }

    /**Crea un nuevo rating con una relación ProductUserRating establecida
     * @param productUserRating Clase que establece la relación entre el producto y el usuario.
     * @see ProductUserRating
     */
    public Rating(ProductUserRating productUserRating) {
        this.productUserRating = productUserRating;
    }

    /**Devuelve la relación entre el producto y el usuario
     * @return Relación producto-usuario
     * @see ProductUserRating
     */
    public ProductUserRating getProductUserRating() {
        return productUserRating;
    }

    /**Define la relacion del Rating entre el producto y el usuario
     * @param productUserRating Relación producto-usuario.
     * @see ProductUserRating
     */
    public void setProductUserRating(ProductUserRating productUserRating) {
        this.productUserRating = productUserRating;
    }

    /**Devuelve el objeto RatingValue que valora el producto
     * @return Valoración del producto.
     * @see RatingValue
     */
    public RatingValue getRatingValue() {
        return ratingValue;
    }

    /**Define la valoración del producto
     * @param ratingValue Valoración del producto
     * @see RatingValue
     */
    public void setRatingValue(RatingValue ratingValue) {
        this.ratingValue = ratingValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rating)) return false;
        Rating rating = (Rating) o;
        return getProductUserRating().equals(rating.getProductUserRating());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductUserRating());
    }

    /**Devuelve una cadena que representa el Rating
     * @return Cadena que representa el Rating
     */
    @Override
    public String toString() {
        return "Rating{" +
                "productUserRating=" + productUserRating +
                ", value=" +
                '}';
    }
}

