package uned.webtechnologies.shop.controllers.input;

import javax.validation.constraints.NotNull;

/**
 * Clase que se encarga de recoger y mapear valores de entrada de la puntuación de un producto.
 */
public class RatingInput {

    @NotNull(message = "El ID del producto no puede ser nulo.")
    private int productId;

    @NotNull(message = "El rating no puede ser nulo.")
    private int count;

    /**
     * Devuelve el identificador del producto.
     *
     * @return Entero con el identificador del producto.
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Método que devuelve la cantidad de puntuaciones.
     *
     * @return Entero con la cantidad de puntuaciones.
     */
    public int getCount() {
        return count;
    }

    /**
     * Establece la cantidad de puntuaciones.
     *
     * @param count Entero con la cantidad de puntuaciones.
     */
    public void setCount(int count) {
        this.count = count;
    }
}