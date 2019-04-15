package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uned.webtechnologies.shop.inmemorydb.model.PurchaseLine;
import uned.webtechnologies.shop.inmemorydb.model.User;

import java.util.Calendar;
import java.util.List;

public interface PurchaseLineRepository extends JpaRepository<PurchaseLine, Long> {
    List<PurchaseLine> findByUser(User user);
    List<PurchaseLine> findAllByDate(Calendar purchaseDate);



}

