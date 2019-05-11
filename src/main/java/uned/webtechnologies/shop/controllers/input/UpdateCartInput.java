package uned.webtechnologies.shop.controllers.input;

import javax.validation.constraints.NotNull;

/**
 * Clase que se encarga de recoger y mapear valores de entrada del carrito para su actualización.
 */
public class UpdateCartInput {

    @NotNull(message = "El ID del producto no puede ser nulo.")
    private int cartId;

    @NotNull(message = "La cantidad no puede ser nula.")
    private int count;

    /**
     * Devuelve el identificador del carrito.
     *
     * @return Un entero con el identificador del carrito.
     */
    public int getCartId() {
        return cartId;
    }

    /**
     * Método que devuelve la cantidad de unidades del carrito.
     *
     * @return Entero con la cantidad de unidades del carrito.
     */
    public int getCount() {
        return count;
    }

    /**
     * Establece el identificador del carrito.
     *
     * @param cartId Un entero con el identificador del carrito.
     */
    public void setCartIdId(int cartId) {
        this.cartId = cartId;
    }

    /**
     * Establece la cantidad de unidades totales del carrito.
     *
     * @param count Entero con la cantidad de unidades del carrito.
     */
    public void setCount(int count) {
        this.count = count;
    }
}
