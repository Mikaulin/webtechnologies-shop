package uned.webtechnologies.shop.inmemorydb.fixtures;

import java.text.ParseException;

/**
 * Interface que deben implementar todas las clases que se encarguen de persistir entidades en la BBDD
 */

public interface ILoader {

    /**
     * Método que se encarga de cargar las entidades en la BBDD
     *
     * @throws ParseException
     */
    void load() throws ParseException;
}
