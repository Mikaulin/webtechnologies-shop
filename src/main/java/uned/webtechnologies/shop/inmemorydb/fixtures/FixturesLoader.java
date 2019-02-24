package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FixturesLoader {
    private UserLoader userLoader;

    @Autowired
    public FixturesLoader(UserLoader userLoader) {
        this.userLoader = userLoader;
    }

    public void execute() {
        userLoader.load();
    }
}
