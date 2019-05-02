package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.RatingValue;
import uned.webtechnologies.shop.inmemorydb.repository.RatingValueRepository;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase encargagda de cargar los RatingValues en el repositorio
 *
 * @see RatingValueRepository
 * @see RatingValue
 */

@Service
public class RatingValueLoader implements ILoader {

    private Logger log = LoggerFactory.getLogger("Application");
    private final RatingValueRepository ratingValueRepository;

    /**
     * Construye un cargador y le asigna su correspondiente repositorio
     *
     * @param ratingValueRepository Repositorio en el que guardar los RatingValues
     * @see RatingValueRepository
     */
    @Autowired
    public RatingValueLoader(RatingValueRepository ratingValueRepository) {
        this.ratingValueRepository = ratingValueRepository;
    }

    /**
     * Método encargado de crear 5 instancias de RatingValue con los valores del 1 al 5 y guardarlos en el RatingValueRepository.
     * Los valores de los RatingValues coinciden con sus IDs debido a la forma en la que se persisten.
     */
    @Override
    public void load() {
        ArrayList<RatingValue> values = new ArrayList<>(
                Arrays.asList(
                        new RatingValue(1),
                        new RatingValue(2),
                        new RatingValue(3),
                        new RatingValue(4),
                        new RatingValue(5)


                )
        );
        ratingValueRepository.save(values);
        log.info("RatingValues cargados en DataBase: " + ratingValueRepository.count());
    }
}
