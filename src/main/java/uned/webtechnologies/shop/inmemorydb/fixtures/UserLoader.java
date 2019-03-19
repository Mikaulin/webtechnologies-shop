package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class UserLoader implements ILoader {

    private Logger log = LoggerFactory.getLogger("Application");
    private final UserRepository userRepository;

    @Autowired
    public UserLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void load() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        ArrayList<User> users = new ArrayList<>(
                Arrays.asList(
                     new User("KikePerez", bCryptPasswordEncoder.encode("123456789")),
                     new User("PabloUzquiano", bCryptPasswordEncoder.encode("123456789")),
                     new User("Mikaulin", bCryptPasswordEncoder.encode("123456789"))
                )
        );
        userRepository.save(users);
        log.info("Users loaded into DataBase: " + users.size());
    }
}
