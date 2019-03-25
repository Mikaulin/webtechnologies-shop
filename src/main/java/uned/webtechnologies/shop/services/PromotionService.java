package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.repository.PromotionRepository;

import java.util.List;
import java.util.Set;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;
    public Set<Product> getProductsByPromotionId(long id){
        return  this.promotionRepository.getPromotionById(id).getProducts();
    }



}
