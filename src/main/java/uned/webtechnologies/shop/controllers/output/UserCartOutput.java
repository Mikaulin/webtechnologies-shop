package uned.webtechnologies.shop.controllers.output;

/**
 * Clase que se encarga de recoger y mapear valores de salida del carrito de un usuario.
 */
public class UserCartOutput implements Output {
    private String message;
    private int totalProducts;

    /**
     * Devuelve el número de productos del carrito de un usuario.
     *
     * @return Un entero con el total de productos.
     */
    public int getTotalProducts() {
        return totalProducts;
    }

    /**
     * Establece el número de productos del carrito de un usuario.
     *
     * @param totalProducts Un entero con el número de productos del carrito de un usuario.
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
