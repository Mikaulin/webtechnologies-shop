package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FixturesLoader {

    private UserLoader userLoader;
    private BrandLoader brandLoader;
    private CategoryLoader categoryLoader;
    private PromotionLoader promotionLoader;
    private ProductLoader productLoader;
    private RatingLoader ratingLoader;
    private RatingValueLoader ratingValueLoader;



    @Autowired
    public FixturesLoader(UserLoader userLoader,
                          BrandLoader brandLoader,
                          CategoryLoader categoryLoader,
                          ProductLoader productLoader,
                          RatingValueLoader ratingValueLoader,
                          RatingLoader ratingLoader,
                          PromotionLoader promotionLoader) {
        this.userLoader = userLoader;
        this.brandLoader = brandLoader;
        this.categoryLoader = categoryLoader;
        this.productLoader = productLoader;
        this.ratingValueLoader=ratingValueLoader;
        this.ratingLoader=ratingLoader;
        this.promotionLoader=promotionLoader;
    }

    public void execute() {
        userLoader.load();
        brandLoader.load();
        categoryLoader.load();
        promotionLoader.load();
        productLoader.load();
        ratingValueLoader.load();;
        ratingLoader.load();
        promotionLoader.load();
    }
}
