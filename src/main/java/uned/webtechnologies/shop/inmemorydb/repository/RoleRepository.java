package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uned.webtechnologies.shop.inmemorydb.model.Role;

/**
 * Monta un respositorio de Roles en la BBDD.
 * @see Role
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    /**Devuelve un role con un nombre dado.
     * @param name Nombre del role que se quiere obtener
     * @return Role
     *
     */
    Role findByName(String name);
}