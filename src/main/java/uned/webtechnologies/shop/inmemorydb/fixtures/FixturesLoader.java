package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FixturesLoader {
    private RoleLoader roleLoader;
    private UserLoader userLoader;
    private BrandLoader brandLoader;
    private CategoryLoader categoryLoader;
    private PromotionLoader promotionLoader;
    private ProductLoader productLoader;
    private RatingLoader ratingLoader;
    private RatingValueLoader ratingValueLoader;
    private PurchaseLinesLoader purchaseLinesLoader;



    @Autowired
    public FixturesLoader(
                          RoleLoader roleLoader,
                          UserLoader userLoader,
                          BrandLoader brandLoader,
                          CategoryLoader categoryLoader,
                          ProductLoader productLoader,
                          RatingValueLoader ratingValueLoader,
                          RatingLoader ratingLoader,
                          PromotionLoader promotionLoader,
                          PurchaseLinesLoader purchaseLinesLoader

    ){
        this.roleLoader = roleLoader;
        this.userLoader = userLoader;
        this.brandLoader = brandLoader;
        this.categoryLoader = categoryLoader;
        this.productLoader = productLoader;
        this.ratingValueLoader=ratingValueLoader;
        this.ratingLoader=ratingLoader;
        this.promotionLoader=promotionLoader;
        this.purchaseLinesLoader=purchaseLinesLoader;
    }

    public void execute() {
        roleLoader.load();
        userLoader.load();
        brandLoader.load();
        categoryLoader.load();
        promotionLoader.load();
        productLoader.load();
        ratingValueLoader.load();
        ratingLoader.load();
        purchaseLinesLoader.load();
    }
}
