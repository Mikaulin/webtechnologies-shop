package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uned.webtechnologies.shop.inmemorydb.model.User;

import java.util.List;

/**
 * Interfaz encargada de montar un respositorio de User en la BBDD.
 *
 * @see JpaRepository
 * @see User
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Método que devuelve todos los usarios activos
     *
     * @return Lista de usuarios activos
     * @see List
     */
    List<User> findByDeletedFalse();

    /**
     * Método que devuelve un usuario si esta activo
     *
     * @param username Nombre del usuario que se quiere obtener
     * @return El usuario "SI" esta activo
     */
    User findByUsernameAndDeletedFalse(String username);

    /**
     * Método que devuelve un usuario con un nombre dado.
     *
     * @param username Nombre del usuario que se desea obtener
     * @return Usuario
     */
    User findByUsername(String username);
}
