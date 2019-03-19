package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FixturesLoader {

    private UserLoader userLoader;
    private BrandLoader brandLoader;
    private CategoryLoader categoryLoader;
    private ProductLoader productLoader;

    @Autowired
    public FixturesLoader(UserLoader userLoader, BrandLoader brandLoader, CategoryLoader categoryLoader, ProductLoader productLoader) {
        this.userLoader = userLoader;
        this.brandLoader = brandLoader;
        this.categoryLoader = categoryLoader;
        this.productLoader = productLoader;
    }

    public void execute() {
        userLoader.load();
        brandLoader.load();
        categoryLoader.load();
        productLoader.load();
    }
}
