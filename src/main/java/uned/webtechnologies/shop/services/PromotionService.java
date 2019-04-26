package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.Promotion;
import uned.webtechnologies.shop.inmemorydb.repository.PromotionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    public Set<Product> getProductsByPromotionId(long id){
        return  this.promotionRepository.getPromotionById(id).getProducts();
    }

    public List<Promotion> getPromotions() {
        return this.promotionRepository.findAll();
    }

    public Promotion getPromotion(long id){return this.promotionRepository.getOne(id);}



    public void save(Promotion promotion) {promotionRepository.save(promotion); }

    public List<Promotion> getActivePromotions(){
        List<Promotion> valids = new ArrayList<>();
        List<Promotion> promos=this.promotionRepository.findAll();
        for (Promotion p:promos) {
            if(p.isActive()){
                valids.add(p);
            }

        }

        return valids;
    }

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
