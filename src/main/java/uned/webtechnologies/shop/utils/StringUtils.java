package uned.webtechnologies.shop.utils;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

/** Clase que implementa utilizades sobre cadenas de texto
 *
 */
public class StringUtils {
    private static final String separator = ", ";

    /** Devuelve una representacion en texto formateada de un Error cambiando los "." por ","
     * @param errors Error sobre el que se desea obtener la representación en texto formateada
     * @return Cadena que representa el error con el formato deseado.
     * @see Errors
     */
    public static String getStringFromErrors(Errors errors) {
        String message = "";
        for (ObjectError error : errors.getAllErrors()) {
            message += error.getDefaultMessage() + separator;
        }
        return replaceLast(message, separator, ".");
    }

    /**
     * Metodo que encarga de modificar una cadena de texto.
     * @param str Cadena que se desea modificar
     * @param original cadena sustituta
     * @param replaced cadena a sustituir por la sustituta
     * @return Cadena con las sustituciones solicitadas
     */
    public static String replaceLast(String str, String original, String replaced) {
        int ind = str.lastIndexOf(original);
        if (ind >= 0)
            str = new StringBuilder(str).replace(ind, ind + 1, replaced).toString();
        return str;
    }

}
