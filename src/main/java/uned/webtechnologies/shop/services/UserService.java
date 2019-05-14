package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.PurchaseLine;
import uned.webtechnologies.shop.inmemorydb.model.Role;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.repository.UserRepository;

import java.util.List;
import java.util.Set;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }


    public User getUser(long id) {
        return this.userRepository.getOne(id);
    }

    public void save(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.addRole(this.roleService.getRoleByName(Role.ROLE_USER));
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void delete(User user) {
        user.setDeleted(true);
        this.userRepository.save(user);
    }

    public Set<PurchaseLine> getPurchaseLines(User user) {
        User u = this.userRepository.getOne(user.getId());
        return u.getPurchaseLines();
    }

    public void update(String username, User user) {
        User updatedUser = findByUsername(username);
        updatedUser.setName(user.getName());
        updatedUser.setLastname1(user.getLastname1());
        updatedUser.setDirection(user.getDirection());
        updatedUser.setCity(user.getCity());
        updatedUser.setProvince(user.getProvince());
        updatedUser.setCountry(user.getCountry());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPhone(user.getPhone());
        updatedUser.setPostalCode(user.getPostalCode());
        save(updatedUser);
    }
}