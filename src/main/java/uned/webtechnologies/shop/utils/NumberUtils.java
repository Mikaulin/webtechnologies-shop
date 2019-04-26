package uned.webtechnologies.shop.utils;

public class NumberUtils {
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
