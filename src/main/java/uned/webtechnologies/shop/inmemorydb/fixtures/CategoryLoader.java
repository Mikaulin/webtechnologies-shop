package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Category;
import uned.webtechnologies.shop.inmemorydb.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.Arrays;


@Service
public class CategoryLoader implements ILoader {

    private Logger log = LoggerFactory.getLogger("Application");
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryLoader(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void load() {
        ArrayList<Category> categories = new ArrayList<>(
                Arrays.asList(
                        new Category("Lavadoras"),
                        new Category("Lavavajillas"),
                        new Category("Congeladores"),
                        new Category("Hornos"),
                        new Category("Secadoras"),
                        new Category("Campanas"),
                        new Category("Frigoríficos"),
                        new Category("Vitrocerámicas")
                )
        );
        categoryRepository.save(categories);
        log.info("Categorias cargadas en DataBase: " + categories.size());
    }
}
