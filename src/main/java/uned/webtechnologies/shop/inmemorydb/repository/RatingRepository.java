package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import uned.webtechnologies.shop.inmemorydb.model.Rating;


import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> getRatingsByProductUserRating_ProductId(long id);
}