package uned.webtechnologies.shop.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uned.webtechnologies.shop.inmemorydb.fixtures.FixturesLoader;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private static final Logger LOG =
            LoggerFactory.getLogger(CommandLineAppStartupRunner.class);


    @Autowired
    FixturesLoader fixturesLoader;

    @Override
    public void run(String...args) throws Exception {
        fixturesLoader.execute();
    }
}