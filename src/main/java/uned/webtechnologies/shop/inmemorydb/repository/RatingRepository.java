package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uned.webtechnologies.shop.inmemorydb.model.Rating;

import java.util.List;

/**
 * Interfaz encargada de montar un repositorio de Rating en la BBDD
 *
 * @see JpaRepository
 * @see Rating
 */
@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {


    /**
     * Método que devuelve todos los ratings de un producto
     *
     * @param id Identificador único del producto sobre el que se realiza la consulta
     * @return Lista de ratings del producto.
     * @see uned.webtechnologies.shop.inmemorydb.model.Product
     */
    List<Rating> getRatingsByProductUserRating_ProductId(long id);


}