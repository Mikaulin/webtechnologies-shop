package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uned.webtechnologies.shop.inmemorydb.model.Cart;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.User;

import java.util.List;

/**
 * Interfaz encargada de montar un repositorio de Carts en la BBDD
 *
 * @see Cart
 * @see JpaRepository
 */

public interface CartRepository extends JpaRepository<Cart, Long> {
    /**
     * Método que define  una lista de Cart (lineas de carrito) que contengan el par usuario-producto
     *
     * @param user    Usuario sobre el que se realiza la consulta
     * @param product Producto sobre el que se realiza la consulta
     * @return Lista de Cart que contengan el par usuario-producto.
     * @see User
     * @see Product
     */
    List<Cart> findByUserAndProduct(User user, Product product);

    /**
     * Método que define  todos los Cart (lineas de carrito) de un usuario
     *
     * @param user Usuario sobre el que se realiza la consulta
     * @return Lista de Cart (lineas de carrito) del usuario
     * @see User
     */
    List<Cart> findByUser(User user);

    /**
     * Método que realiza una consulta a la BBDD que vuelve  el sumatorio de productos del usuario
     *
     * @param userId Identificador único del usuario sobre el que se realiza la consulta.
     * @return Entero con la cantidad total de productos del usuario
     */
    @Query(value = "SELECT sum(c.COUNT) FROM CART c WHERE c.ID_USER=:userId", nativeQuery = true)
    Integer sumUserCartUnits(@Param("userId") Long userId);

    /**
     * Método que define  la cantidad de carts de un usuario
     *
     * @param user Usuario del que se quieren obtener el total de Lineas de carrito
     * @return Cantidad de lineas de carrito del usuario.
     * @see User
     */
    Long countByUser(User user);
}

