package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.repository.RoleRepository;
import uned.webtechnologies.shop.inmemorydb.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;

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
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        ArrayList<User> users = new ArrayList<>(
                Arrays.asList(
                        new User("Enrique", "Pérez", "Paseo Morlans 4","Donostia", 20009,"Gipuzkoa","España", "kike@hotmail.com","688243155", "KikePerez", bCryptPasswordEncoder.encode("123456789")),
                        new User("Pablo", "Uzquiano", "Calle Mayor 5","Renteria", 20010,"Gipuzkoa","España", "pablo@hotmail.com","6872455901", "PabloUzquiano", bCryptPasswordEncoder.encode("123456789")),
                        new User("Mikel", "Mikaulin", "Calle Altuna 6","Renteria", 20010,"Gipuzkoa","España", "mikel@hotmail.com","677224391", "Mikaulin", bCryptPasswordEncoder.encode("123456789"))
                )
        );
        userRepository.save(users);
        log.info("Users loaded into DataBase: " + users.size());
    }
}
