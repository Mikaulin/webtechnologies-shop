package uned.webtechnologies.shop.controllers.output;

/**
 * Clase que se encarga de recoger y mapear valores de salida de la actualización de un carrito.
 */
public class UpdateCartOutput implements Output {
    private String message;

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
