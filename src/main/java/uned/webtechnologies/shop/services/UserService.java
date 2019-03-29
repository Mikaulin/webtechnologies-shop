package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.repository.RoleRepository;
import uned.webtechnologies.shop.inmemorydb.repository.UserRepository;

import java.util.HashSet;
import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<User> getUser() {
        return this.userRepository.findAll();
    }

    public void save(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
/*        user.setName(user.getName());
        user.setLastname1(user.getLastname1());
        user.setDirection(user.getDirection());
        user.setPostalCode(user.getPostalCode());
        user.setCity(user.getCity());
        user.setProvince(user.getProvince());
        user.setCountry(user.getCountry());
        user.setPhone(user.getPhone());*/
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}