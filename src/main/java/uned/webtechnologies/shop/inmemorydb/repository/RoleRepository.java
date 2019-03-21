package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uned.webtechnologies.shop.inmemorydb.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
