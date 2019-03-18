package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FixturesLoader {

    private UserLoader userLoader;
    private ProductLoader productLoader;


    @Autowired
    public FixturesLoader(UserLoader userLoader, ProductLoader productLoader) {

        this.userLoader = userLoader;
        this.productLoader = productLoader;
    }

    public void execute() {

        userLoader.load();
        productLoader.load();
    }
}
