package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uned.webtechnologies.shop.inmemorydb.model.Category;

/**
 * Monta un repositorio de Categorias en la BBDD
 * @see JpaRepository
 * @see Category
 */

@Repository

public interface CategoryRepository extends JpaRepository<Category,Long> {

}