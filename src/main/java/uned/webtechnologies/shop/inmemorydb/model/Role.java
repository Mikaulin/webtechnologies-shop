package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * Esta clase Método que define un Role de usuario.
 *
 * @see User
 */

@Entity
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Role() {
    }


    /**
     * Construye un Role con un nombre de rol
     *
     * @param name Nombre del rol
     */
    public Role(String name) {
        this.name = name;
    }


    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    /**
     * Método que devuelve el identificador único del Role
     *
     * @return Identificador único del Role
     */
    public Long getId() {
        return id;
    }

    /**
     * Método que define el identificador único del Role
     *
     * @param id Identificador único del Role
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que devuelve el nombre del Role
     *
     * @return Nombre del Role
     */
    public String getName() {
        return name;
    }

    /**
     * Método que define el nombre del Role
     *
     * @param name Nombre del Role
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método que devuelve el conjunto de usuarios que tienen este Role
     *
     * @return Conjunto "Set" de Usuarios que tienen este Role
     * @see User
     * @see Set
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * Método que define los usuarios a los que se les asigna este Role
     *
     * @param users Conjunto de usuarios a los que se les asigna este Role
     * @see User
     * @see Set
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
