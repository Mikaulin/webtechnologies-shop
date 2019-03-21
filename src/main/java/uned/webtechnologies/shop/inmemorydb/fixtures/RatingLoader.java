package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.Rating;
import uned.webtechnologies.shop.inmemorydb.model.RatingValue;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.repository.ProductRepository;
import uned.webtechnologies.shop.inmemorydb.repository.RatingRepository;
import uned.webtechnologies.shop.inmemorydb.repository.RatingValueRepository;
import uned.webtechnologies.shop.inmemorydb.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RatingLoader implements ILoader {

    private Logger log = LoggerFactory.getLogger("Application");
    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final RatingValueRepository ratingValueRepository;


    @Autowired
    public RatingLoader(RatingRepository ratingRepository,UserRepository userRepository,ProductRepository productRepository,RatingValueRepository ratingValueRepository){
        this.ratingRepository=ratingRepository;
        this.userRepository=userRepository;
        this.productRepository=productRepository;
        this.ratingValueRepository=ratingValueRepository;
    }

    @Override
    public void load() {
        List<User> userList = this.userRepository.findAll();
        List<Product> productList = this.productRepository.findAll();
        List<RatingValue> valuesList = this.ratingValueRepository.findAll();


        Rating r1=new Rating();
        Rating r2=new Rating();
        Rating r3=new Rating();
        Rating r4=new Rating();
        Rating r5=new Rating();
        r1.setProductId(productList.get(1).getId());
        r1.setUserId(userList.get(1).getId());
        r1.setRatingValue(valuesList.get(2));
        r2.setProductId(productList.get(1).getId());
        r2.setUserId(userList.get(1).getId());
        r2.setRatingValue(valuesList.get(1));
        r3.setProductId(productList.get(2).getId());
        r3.setUserId(userList.get(1).getId());
        r3.setRatingValue(valuesList.get(1));








        ratingRepository.save(r2);
        ratingRepository.save(r1);
        ratingRepository.save(r3);


        log.info("Ratings cargados en DataBase: " +ratingRepository.count());
    }
}
