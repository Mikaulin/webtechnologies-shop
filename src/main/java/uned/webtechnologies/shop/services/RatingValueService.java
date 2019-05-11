package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.RatingValue;
import uned.webtechnologies.shop.inmemorydb.repository.RatingValueRepository;

/**Servicio que implementa la lógica de negócio del MVC entre el controlador y las RatingValues del modelo
 * @see RatingValueRepository
 * @see RatingValue
 */

@Service
public class RatingValueService {
    @Autowired
    private RatingValueRepository ratingValueRepository;

    /**Método que devuelve una RatingValue del repositorio
     * @param id Identificaro único del RatingValue que se desea
     * @return RatingValue
     * @see RatingValueRepository
     * @see RatingValue
     */
    public RatingValue getOne(long id){
        return this.ratingValueRepository.getOne(id);
    }
}
