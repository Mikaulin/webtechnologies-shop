package uned.webtechnologies.shop.inmemorydb.repository;

import uned.webtechnologies.shop.inmemorydb.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}