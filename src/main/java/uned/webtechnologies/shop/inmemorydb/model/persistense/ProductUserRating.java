package uned.webtechnologies.shop.inmemorydb.model.persistense;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Esta clase establece la relacion entre usuarios y productos.
 * Se utiliza para las valoraciones ("Rating") de productos.
 *
 * @see uned.webtechnologies.shop.inmemorydb.model.Rating
 */

@Embeddable
public class ProductUserRating implements Serializable {

    private long userId;

    private long productId;

    public ProductUserRating() {
    }

    /**
     * Devuelve el identificador único del usuario
     *
     * @return Identificador único del usuario
     * @see uned.webtechnologies.shop.inmemorydb.model.User
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Define el identificador del usuario
     *
     * @param userId Identificador único del usuario
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * Devuelve el identificador único del producto
     *
     * @return Identificador único del producto
     */
    public long getProductId() {
        return productId;
    }

    /**
     * Define el identificador único del producto.
     *
     * @param productId Identificador único del producto
     */
    public void setProductId(long productId) {
        this.productId = productId;
    }

    /**
     * Devuelve una cadena que representa la relación
     *
     * @return Cadena que representa la relación
     */
    @Override
    public String toString() {
        return "ProductUserRating{" +
                "userId=" + userId +
                ", productId=" + productId +
                '}';
    }
}
