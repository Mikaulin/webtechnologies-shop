package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.repository.PromotionRepository;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;



}
