package uned.webtechnologies.shop.controllers.input;

import javax.validation.constraints.NotNull;

/**
 * Clase que se encarga de recoger y mapear valores de entrada del carrito.
 */
public class AddCartInput {

    @NotNull(message = "El ID del producto no puede ser nulo.")
    private int productId;

    @NotNull(message = "La cantidad no puede ser nula.")
    private int count;

    /**
     * Método que devuelve el identificador del producto.
     *
     * @return Entero con el identificador del producto.
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Método que devuelve la cantidad de unidades del producto.
     *
     * @return Entero con la cantidad de unidades del producto.
     */
    public int getCount() {
        return count;
    }

    /**
     * Establece el identificador del producto.
     *
     * @param productId Entero con el identificador del producto.
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Establece la cantidad de unidades del producto.
     *
     * @param count Entero con la cantidad de unidades del producto.
     */
    public void setCount(int count) {
        this.count = count;
    }
}
