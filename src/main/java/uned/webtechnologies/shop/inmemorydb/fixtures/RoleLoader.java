package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Role;
import uned.webtechnologies.shop.inmemorydb.repository.RoleRepository;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class RoleLoader implements ILoader {
    private Logger log = LoggerFactory.getLogger(RoleLoader.class);
    private final RoleRepository roleRepository;

    @Autowired
    public RoleLoader(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void load() {
        ArrayList<Role> roles = new ArrayList<>(
                Arrays.asList(
                        new Role(Role.ROLE_ADMIN),
                        new Role(Role.ROLE_USER)
                )
        );
        roleRepository.save(roles);
        log.info("Roles loaded into DataBase: " + roles.size());
    }
}