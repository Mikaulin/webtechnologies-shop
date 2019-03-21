package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Brand;
import uned.webtechnologies.shop.inmemorydb.model.RatingValue;
import uned.webtechnologies.shop.inmemorydb.repository.BrandRepository;
import uned.webtechnologies.shop.inmemorydb.repository.RatingValueRepository;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class RatingValueLoader implements ILoader {

    private Logger log = LoggerFactory.getLogger("Application");
    private final RatingValueRepository ratingValueRepository;

    @Autowired
    public RatingValueLoader(RatingValueRepository ratingValueRepository){
        this.ratingValueRepository=ratingValueRepository;
    }

    @Override
    public void load() {
        ArrayList<RatingValue> values = new ArrayList<>(
                Arrays.asList(
                        new RatingValue(1),
                        new RatingValue(2),
                        new RatingValue(3),
                        new RatingValue(4),
                        new RatingValue(5)


                )
        );
        ratingValueRepository.save(values);
        log.info("RatingValues cargados en DataBase: " +ratingValueRepository.count());
    }
}
