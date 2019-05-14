package uned.webtechnologies.shop.controllers.output;

/**
 * Interface que deberán implementar todas las clases que sirven para devolver datos vía Ajax.
 */
public interface Output {
    String getMessage();

    void setMessage(String message);
}
