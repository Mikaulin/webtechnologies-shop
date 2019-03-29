package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.Rating;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.model.persistense.ProductUserRating;
import uned.webtechnologies.shop.inmemorydb.repository.ProductRepository;
import uned.webtechnologies.shop.inmemorydb.repository.RatingRepository;
import uned.webtechnologies.shop.inmemorydb.repository.RatingValueRepository;
import uned.webtechnologies.shop.inmemorydb.repository.UserRepository;

import java.util.List;

@Service
public class RatingLoader implements ILoader {

    private Logger log = LoggerFactory.getLogger("Application");
    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final RatingValueRepository ratingValueRepository;


    @Autowired
    public RatingLoader(RatingRepository ratingRepository, UserRepository userRepository, ProductRepository productRepository, RatingValueRepository ratingValueRepository){
        this.ratingRepository=ratingRepository;
        this.userRepository=userRepository;
        this.productRepository=productRepository;
        this.ratingValueRepository=ratingValueRepository;
    }

    @Override
    public void load() {
        List<User> userList = this.userRepository.findAll();
        List<Product> productList = this.productRepository.findAll();
        Rating r = new Rating();
        ProductUserRating productUserRating = new ProductUserRating();
        long id;

        for (User user : userList) {
            productUserRating.setUserId(user.getId());
            for (Product product : productList) {
                productUserRating.setProductId(product.getId());
                r.setProductUserRating(productUserRating);
                id = (long) Math.floor(Math.random() * 5 + 1);
                r.setRatingValue(this.ratingValueRepository.getOne(id));
                this.ratingRepository.save(r);
            }
        }
        log.info("Ratings cargados en DataBase: " + ratingRepository.count());
    }
}
