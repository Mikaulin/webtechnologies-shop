package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uned.webtechnologies.shop.inmemorydb.model.Role;

/**
 * Interfaz encargada de montar un respositorio de Roles en la BBDD.
 *
 * @see JpaRepository
 * @see Role
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * Método que devuelve un role con un nombre dado.
     *
     * @param name Nombre del role que se quiere obtener
     * @return Role
     */
    Role findByName(String name);
}