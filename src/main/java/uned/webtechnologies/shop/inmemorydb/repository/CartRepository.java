package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import uned.webtechnologies.shop.inmemorydb.model.Cart;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.User;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUserAndProduct(User user, Product product);
    List<Cart> findByUser(User user);

    @Query(value="SELECT sum(c.COUNT) FROM CART c WHERE c.ID_USER=:userId", nativeQuery = true)
    Integer sumUserCartUnits(@Param("userId") Long userId);

}

