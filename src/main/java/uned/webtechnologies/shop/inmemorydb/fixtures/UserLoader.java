package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.repository.UserRepository;

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
        User user1 = new User("Kike", bCryptPasswordEncoder.encode("test"), 20);
        User user2 = new User("Pablo", bCryptPasswordEncoder.encode("test"), 25);
        User user3 = new User("Mikel", bCryptPasswordEncoder.encode("test"), 30);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        log.info("Users loaded into DataBase: " + userRepository.count());
    }
}
