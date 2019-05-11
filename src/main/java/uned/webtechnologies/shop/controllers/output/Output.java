package uned.webtechnologies.shop.controllers.output;

/**
 * Interface que deberán implementar todas las clases que sirven para devolver datos vía Ajax.
 */
public interface Output  {
    public String getMessage();
    public void setMessage(String message);
}
