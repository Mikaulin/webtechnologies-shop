package uned.webtechnologies.shop.controllers.output;

/**
 * Clase que se encarga de recoger y mapear valores de salida de la puntuación de un producto.
 */
public class RatingOutput implements Output{
    private String message;
    private double averageRating;
    private double ratingPercent;

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

    /**
     * Devuelve la media de puntuaciones del producto.
     *
     * @return Un double con la media de puntuaciones del producto.
     */
    public double getAverageRating() {
        return averageRating;
    }

    /**
     * Devuelve el porcentaje de la media.
     *
     * @return Un double con el porcentaje de la media.
     */
    public double getRatingPercent() {
        return ratingPercent;
    }

    /**
     * Establece la media de puntuaciones del producto.
     *
     * @param averageRating Double de la media de puntuaciones del producto.
     */
    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    /**
     * Establece el porcentaje de la media.
     *
     * @param ratingPercent Double del porcentaje de la media.
     */
    public void setRatingPercent(double ratingPercent) {
        this.ratingPercent = ratingPercent;
    }
}