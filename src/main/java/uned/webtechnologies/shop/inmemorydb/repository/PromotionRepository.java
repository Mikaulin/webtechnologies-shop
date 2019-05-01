package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uned.webtechnologies.shop.inmemorydb.model.Promotion;

/**
 * Define un repositorio de Promociones
 *
 * @see Promotion
 */

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    /**
     * Devuelve una promoción
     *
     * @param id Identificador único de la promoción
     * @return Promoción
     */
    Promotion getPromotionById(long id);

}


