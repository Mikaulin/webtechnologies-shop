package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Brand;
import uned.webtechnologies.shop.inmemorydb.model.Category;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.repository.BrandRepository;
import uned.webtechnologies.shop.inmemorydb.repository.CategoryRepository;
import uned.webtechnologies.shop.inmemorydb.repository.ProductRepository;


@Service

public class CategorytLoader implements ILoader {

    private Logger log2 = LoggerFactory.getLogger("Application");

    private final CategoryRepository categoryRepository;



    @Autowired
    public CategorytLoader( CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;


    }

    @Override
    public void load() {

        Category ge = new Category("Grandes electrodomesticos");
        categoryRepository.save(ge);
        Category fri = new Category("frigorificos");
        categoryRepository.save(fri);
        Category vitro = new Category("vitroceramicas");
        categoryRepository.save(vitro);









        log2.info("Categorias cargadas en DataBase: " + categoryRepository.count());

    }


}
