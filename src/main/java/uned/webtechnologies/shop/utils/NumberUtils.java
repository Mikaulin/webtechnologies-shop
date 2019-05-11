package uned.webtechnologies.shop.utils;

/**
 *  Clase que implementa utilizades sobre operaciones con números
 */

public class NumberUtils {
    /**Método estático utilizado para redondear numeros con decimales a 2 decimales
     * @param valorInicial  numero con decimales que se desea redondear a 2 decimales
     * @return Numero redondeado a 2 decimales
     */
    public static double roundDecimals(double valorInicial) {
        final int NUMDECIMALES=2;
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, NUMDECIMALES);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, NUMDECIMALES))+parteEntera;
        return resultado;
    }
}
