package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FixturesLoader {
    private RoleLoader roleLoader;
    private UserLoader userLoader;
    private BrandLoader brandLoader;
    private CategoryLoader categoryLoader;
    private ProductLoader productLoader;
    private RatingLoader ratingLoader;
    private RatingValueLoader ratingValueLoader;

    @Autowired
    public FixturesLoader(RoleLoader roleLoader,
                          UserLoader userLoader,
                          BrandLoader brandLoader,
                          CategoryLoader categoryLoader,
                          ProductLoader productLoader,
                          RatingValueLoader ratingValueLoader,
                          RatingLoader ratingLoader
    ) {
        this.roleLoader = roleLoader;
        this.userLoader = userLoader;
        this.brandLoader = brandLoader;
        this.categoryLoader = categoryLoader;
        this.productLoader = productLoader;
        this.ratingValueLoader = ratingValueLoader;
        this.ratingLoader = ratingLoader;
    }

    public void execute() {
        roleLoader.load();
        userLoader.load();
        brandLoader.load();
        categoryLoader.load();
        productLoader.load();
        ratingValueLoader.load();
        ratingLoader.load();
    }
}
