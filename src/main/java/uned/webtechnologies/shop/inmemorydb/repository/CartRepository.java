package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uned.webtechnologies.shop.inmemorydb.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}