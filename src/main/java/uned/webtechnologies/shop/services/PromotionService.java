package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.Promotion;
import uned.webtechnologies.shop.inmemorydb.repository.PromotionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**Servicio que implementa la lógica de negócio del MVC entre el controlador y las Promociones del modelo
 * @see PromotionRepository
 * @see Promotion
 */

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    /**
     * Método que un conjunto de productos que tienen una promoción concreta asignada del repositorio de promociónes
     *
     * @param id Identificador único de la promoción sobre la que se realiza la consulta
     * @return Conjunto de productos que tienen asignada una promoción concreta
     * @see PromotionRepository
     * @see Promotion
     * @see Product
     */
    public Set<Product> getProductsByPromotionId(long id) {
        return this.promotionRepository.getPromotionById(id).getProducts();
    }

    /**
     * Método que devuelve las promociónes del repositorio
     *
     * @return Lista de promociónes del repositorio
     * @see PromotionRepository
     * @see Promotion
     */
    public List<Promotion> getPromotions() {
        return this.promotionRepository.findAll();
    }

    /**
     * Método que devuelve una promoción del repositorio
     *
     * @param id Identificador único de la promoción que se desea
     * @return promoción del repositorio
     * @see PromotionRepository
     * @see Promotion
     */
    public Promotion getPromotion(long id) {
        return this.promotionRepository.getOne(id);
    }


    /**
     * Método que guarda o actualiza una promoción en el repositorio
     *
     * @param promotion Promoción que se desea guardar o actualizar
     * @see PromotionRepository
     * @see Promotion
     */
    public void save(Promotion promotion) {
        promotionRepository.save(promotion);
    }

    /**Método que devuelve las promociones del repositorio que se encuentran activas en el momento de la consulta
     * @return Lista de promociones activas en el momento de la consulta
     * @see PromotionRepository
     * @see Promotion
     */
    public List<Promotion> getActivePromotions() {
        List<Promotion> valids = new ArrayList<>();
        List<Promotion> promos = this.promotionRepository.findAll();
        for (Promotion p : promos) {
            if (p.isActive()) {
                valids.add(p);
            }

        }

        return valids;
    }

    /**Método que actualiza una promoción en el repositorio
     * @param id Identificador único de la promoción que se desea actualizar
     * @param promotion promoción con la nueva información
     * @see PromotionRepository
     * @see Promotion
     */
    public void update(long id, Promotion promotion) {
        Promotion updatedPromotion = getPromotion(id);
        updatedPromotion.setName(promotion.getName());
        updatedPromotion.setDescription(promotion.getDescription());
        updatedPromotion.setStartDate(promotion.getStartDate());
        updatedPromotion.setEndDate(promotion.getEndDate());
        updatedPromotion.setDiscount(promotion.getDiscount());
        save(updatedPromotion);
    }

}
