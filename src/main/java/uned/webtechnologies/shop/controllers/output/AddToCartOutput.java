package uned.webtechnologies.shop.controllers.output;

/**
 * Clase que se encarga de recoger y mapear valores de salida del carrito para su actualización.
 */
public class AddToCartOutput implements Output {
    private String message;
    private int totalProducts;

    /**
     * Obtiene el número total de productos del carrito.
     *
     * @return Entero con el número total de elementos del carrito.
     */
    public int getTotalProducts() {
        return totalProducts;
    }

    /**
     * Establece el número total de productos del carrito.
     *
     * @param totalProducts ENtero con el número total de productos del carrito.
     */
    public void setTotalProducts(int totalProducts) {
        this.totalProducts = totalProducts;
    }

    /**
     * Devuelve el mensaje que se mostrará por pantalla al cliente.
     *
     * @return Un String con el estado de la petición Ajax.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Establece un mensaje de respuesta.
     *
     * @param message Un String para notificar al usuario por el estado de la operación.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
