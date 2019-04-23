package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Esta clase se utiliza para valorar productos.
 * La idea de esta clase es persistir tantos objetos RatingValue como valoraciónes se deseen para los productos.
 * En el contexto de la presenta práctica, las valoraciones deben estar comprendidas entre 1 estrella y 5 estrellas, por lo que deberán existir 5 objetos de RatingValue con valores del 1 al 5.
 */
@Entity
public class RatingValue implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private int value;
    public RatingValue(){}


    /**Crea un nuevo RatingValue con un valor.
     * @param value Entero con el valor del RatingValue
     */
    public RatingValue(int value){
        this.value=value;
    }

    /**Devuelve el valor del RatingValue
     * @return Entero con el valor del RatingValue
     */
    public int getValue() {
        return value;
    }

    /** Define el valor del RatingValue
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**Devuelve el identificador único del RatingValue
     * @return long con el identificador único del RatingValue
     */
    public long getId() {
        return id;
    }

    /**Devuelve una cadena que representa el RatingValue
     * @return Cadena que representa el RatingValue
     */
    @Override
    public String toString() {
        return "RatingValues{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
