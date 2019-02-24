package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
        User user1 = new User(1L, "Kike", "test", 20);
        User user2 = new User(2L, "Pablo", "test", 25);
        User user3 = new User(3L, "Mikel", "test", 30);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        log.info("Users loaded into DataBase: " + userRepository.count());
    }
}
