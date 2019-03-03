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
        User user1 = new User(1L, "Pepe", "Perez", "amara", "Donostia", "Spain", "pepe@hotmail.com","943672299",20009 ,"pepe1273", "test");
        User user2 = new User(2L, "Luis", "Martinez", "centro", "Donostia","Spain","luis@hotmail.com","943789931",20008,"luis0034", "test");
        User user3 = new User(3L, "Jose", "Sanchez", "amara", "Donostia","Spain","jose@hotmail.com","943376610",20008,"jose8713", "test");
        User user4 = new User(4L, "Carlos", "Lopez", "gros", "Donostia","Spain","carlos@hotmail.com","943822456",20008,"carlos8822", "test");
        User user5 = new User(5L, "Juan", "Garcia", "antiguo", "Donostia","Spain","juan@hotmail.com","943992152",20008,"juan1232", "test");
        User user6 = new User(6L, "Ana", "Fernandez", "centro", "Donostia","Spain","ana@hotmail.com","943002711",20008,"ana9022", "test");
        User user7 = new User(7L, "Marta", "Rodriguez", "antiguo", "Donostia","Spain","marta@hotmail.com","943962701",20008,"marta2322", "test");
        User user8 = new User(8L, "Javi", "gomez", "centro", "Donostia","Spain","javi@hotmail.com","943025518",20008,"javi8911", "test");
        User user9 = new User(9L, "Maria", "Martin", "centro", "Donostia","Spain","maria@hotmail.com","943626272",20008,"maria7178", "test");


        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        userRepository.save(user7);
        userRepository.save(user8);
        userRepository.save(user9);

        log.info("Users loaded into DataBase: " + userRepository.count());
    }
}
