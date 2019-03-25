package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Role;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.repository.RoleRepository;
import uned.webtechnologies.shop.inmemorydb.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserLoader implements ILoader {

    private Logger log = LoggerFactory.getLogger(UserLoader.class);
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserLoader(
            UserRepository userRepository,
            RoleRepository roleRepository
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void load() {
        Role roleAdmin = roleRepository.findByName("ROLE_ADMIN");

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        ArrayList<User> users = new ArrayList<>(
                Arrays.asList(
                        new User("Admin", bCryptPasswordEncoder.encode("admin"), roleAdmin),
                        new User("KikePerez", bCryptPasswordEncoder.encode("123456789")),
                        new User("PabloUzquiano", bCryptPasswordEncoder.encode("123456789")),
                        new User("Mikaulin", bCryptPasswordEncoder.encode("123456789"))
                )
        );
        userRepository.save(users);
        log.info("Users loaded into DataBase: " + users.size());
    }
}
