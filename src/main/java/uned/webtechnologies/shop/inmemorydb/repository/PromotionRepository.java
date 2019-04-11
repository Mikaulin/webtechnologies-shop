package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.Promotion;

import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    Promotion getPromotionById(long id);





}


