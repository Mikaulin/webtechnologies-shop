package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uned.webtechnologies.shop.inmemorydb.model.Photo;


@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

     Photo getByUrl(String url);
}