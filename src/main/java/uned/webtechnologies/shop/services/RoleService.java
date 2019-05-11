package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Role;
import uned.webtechnologies.shop.inmemorydb.repository.RoleRepository;

@Service
public class RoleService {
    /**Servicio que implementa la lógica de negócio del MVC entre el controlador y los Roles del modelo
     *
     */
    @Autowired
    private RoleRepository roleRepository;

    /**
     * @param name Nombre del role que se obtiene del repositorio
     * @return Role
     * @see RoleRepository#findByName(String)
     */
    public Role getRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}
