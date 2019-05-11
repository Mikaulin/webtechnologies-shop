package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uned.webtechnologies.shop.inmemorydb.model.PurchaseLine;
import uned.webtechnologies.shop.inmemorydb.model.User;

import java.util.Calendar;
import java.util.List;

/**
 * Interfaz encargada de montar un repositorio de PurchaseLines (lineas de compra) en la BBDD
 *
 * @see JpaRepository
 * @see PurchaseLine
 */

public interface PurchaseLineRepository extends JpaRepository<PurchaseLine, Long> {
    /**
     * Método que devuelve las lineas de compra de un usuario
     *
     * @param user Usuario del que se quieren obtener las lineas de compra
     * @return Lista con las lineas de compra del usuario
     * @see User
     * @see List
     */
    List<PurchaseLine> findByUser(User user);

    /**
     * Método que devuelve las lineas de compra de un día concreto
     *
     * @param purchaseDate Calendar que contiene la fecha sobre la que se realiza la consulta
     * @return Lista de lineas de compra
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html">Calendar</a>
     */
    List<PurchaseLine> findAllByDate(Calendar purchaseDate);


}

