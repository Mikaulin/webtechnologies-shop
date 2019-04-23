package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uned.webtechnologies.shop.inmemorydb.model.Brand;

/**
 * Monta un repositorio de Marcas en la BBDD
 * @see Brand
 * @see JpaRepository
 */

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}