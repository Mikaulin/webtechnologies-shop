package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.Rating;
import uned.webtechnologies.shop.inmemorydb.model.RatingValue;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.model.persistense.ProductUserRating;
import uned.webtechnologies.shop.inmemorydb.repository.ProductRepository;
import uned.webtechnologies.shop.inmemorydb.repository.RatingRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private ProductService productService;

    public List<Product> getProductsByRating(int rating) {
        List<Product> products = this.productService.getProducts();
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (getProductRating(p.getId()) == rating) {
                result.add(p);
            }
        }
        return result;
    }

    public void setProductRating(User user, Product product, RatingValue ratingValue) {
        Rating rating = new Rating();
        ProductUserRating productUserRating = new ProductUserRating();
        productUserRating.setProductId(product.getId());
        productUserRating.setUserId(user.getId());
        rating.setProductUserRating(productUserRating);
        rating.setRatingValue(ratingValue);
        this.ratingRepository.save(rating);
    }

    public int getProductRating(long id) {
        List<Rating> ratings = this.ratingRepository.getRatingsByProductUserRating_ProductId(id);
        return getRatingAVG(ratings);
    }

    private int getRatingAVG(List<Rating> ratings) {
        if (ratings.isEmpty()) return 0;
        float total = 0;
        int count = ratings.size();

        for (Rating r : ratings) {
            total = total + r.getRatingValue().getValue();
        }

        return Math.round(total / count);
    }
}