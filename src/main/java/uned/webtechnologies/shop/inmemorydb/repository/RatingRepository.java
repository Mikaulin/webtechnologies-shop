package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.Rating;
import uned.webtechnologies.shop.inmemorydb.model.RatingValue;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

     int countRatingsByProductIdAndRatingValue_Value(int id,int value);





}