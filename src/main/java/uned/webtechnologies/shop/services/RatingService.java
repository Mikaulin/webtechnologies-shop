package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.*;
import uned.webtechnologies.shop.inmemorydb.repository.ProductRepository;
import uned.webtechnologies.shop.inmemorydb.repository.RatingRepository;
import uned.webtechnologies.shop.inmemorydb.repository.RatingValueRepository;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;




    public int getProductRating(long id){

        List<Rating> ratings=this.ratingRepository.getRatingsByProductUserRating_ProductId(id);

     return getRatingAVG(ratings);
    }
    private int getRatingAVG(List<Rating> ratings){
        if (ratings.isEmpty()) return 0;
        int total=0;
        int count=ratings.size();

        for (Rating r:ratings){
            total=total+r.getRatingValue().getValue();
        }

        return total/count;
    }



}

