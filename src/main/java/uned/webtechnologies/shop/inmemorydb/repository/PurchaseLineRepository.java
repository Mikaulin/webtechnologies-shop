package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uned.webtechnologies.shop.inmemorydb.model.PurchaseLine;
import uned.webtechnologies.shop.inmemorydb.model.User;

import java.util.Calendar;
import java.util.List;

/**
 * Monta un repositorio de PurchaseLines (lineas de compra) en la BBDD
 * @see PurchaseLine
 *
 */

public interface PurchaseLineRepository extends JpaRepository<PurchaseLine, Long> {
    List<PurchaseLine> findByUser(User user);

    /** Devuelva las lineas de compra de un día concreto
     * @param purchaseDate Calendar que contiene la fecha sobre la que se realiza la consulta
     * @return Lista de lineas de compra
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html">Calendar</a>
     */
    List<PurchaseLine> findAllByDate(Calendar purchaseDate);



}

