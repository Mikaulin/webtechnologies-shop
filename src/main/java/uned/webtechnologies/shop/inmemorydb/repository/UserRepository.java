package uned.webtechnologies.shop.inmemorydb.repository;

import uned.webtechnologies.shop.inmemorydb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
