package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.RatingValue;
import uned.webtechnologies.shop.inmemorydb.repository.RatingValueRepository;

@Service
public class RatingValueService {
    @Autowired
    private RatingValueRepository ratingValueRepository;

    public RatingValue getOne(long id){
        return this.ratingValueRepository.getOne(id);
    }
}
