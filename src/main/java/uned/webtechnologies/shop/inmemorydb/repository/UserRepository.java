package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uned.webtechnologies.shop.inmemorydb.model.User;

/**
 * Monta un respositorio de User en la BBDD.
 * @see User
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**Devuelve un usuario con un nombre dado.
     * @param username Nombre del usuario que se desea obtener
     * @return Usuario
     */
    User findByUsername(String username);
}
