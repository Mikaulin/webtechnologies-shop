package uned.webtechnologies.shop.inmemorydb.repository;

import uned.webtechnologies.shop.inmemorydb.model.Brand;
import uned.webtechnologies.shop.inmemorydb.model.Category;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
     List<Product> getProductByCategory(Category category);
     List<Product> getProductByBrand(Brand brand);
     List<Product> getTop8ProductByFeaturedTrue();
     List<Product> getProductByBrandId(long id);
     List<Product> getProductByCategoryId(long id);
}