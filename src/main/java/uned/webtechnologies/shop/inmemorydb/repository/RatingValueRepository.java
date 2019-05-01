package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uned.webtechnologies.shop.inmemorydb.model.RatingValue;

/**
 * Monta un repositorio de RatingValue en la BBDD
 * @see RatingValue
 */

@Repository
public interface RatingValueRepository extends JpaRepository<RatingValue, Long> {



}