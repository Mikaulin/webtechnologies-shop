package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Role;
import uned.webtechnologies.shop.inmemorydb.repository.RoleRepository;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase encargada de cargar los Roles en su respositorio.
 *
 * @see RoleRepository
 * @see Role
 */

@Service
public class RoleLoader implements ILoader {
    private Logger log = LoggerFactory.getLogger(RoleLoader.class);
    private final RoleRepository roleRepository;

    /**
     * Construye un cargador y le asigna su correspondiente repositorio
     *
     * @param roleRepository Repositorio en el que guardar los roles
     * @see RoleRepository
     */
    @Autowired
    public RoleLoader(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Metodo encargado de crear dos instancias de Role y cargarlas en el repositorio.
     * <p>Roles cargados</p>
     * <ul>
     * <li>ROLE_ADMIN</li>
     * <li>ROLE_USER</li>
     * </ul>
     */
    @Override
    public void load() {
        ArrayList<Role> roles = new ArrayList<>(
                Arrays.asList(
                        new Role("ROLE_ADMIN"),
                        new Role("ROLE_USER")
                )
        );
        roleRepository.save(roles);
        log.info("Roles loaded into DataBase: " + roles.size());
    }
}