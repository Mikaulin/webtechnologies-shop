package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Category;
import uned.webtechnologies.shop.inmemorydb.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase encargada de cargar Categorias en el respositorio de categorias.
 *
 * @see CategoryRepository
 * @see Category
 */


@Service
public class CategoryLoader implements ILoader {

    private Logger log = LoggerFactory.getLogger("Application");
    private final CategoryRepository categoryRepository;

    /**
     * Construye un cargador asignandole su correspondiente repositorio
     *
     * @param categoryRepository Repositorio de categorias
     * @see CategoryRepository
     */
    @Autowired
    public CategoryLoader(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Metodo encargado de crear instancias de categorias y guardarlas en el repositorio.
     * <P>Categorías cargadas</P>
     * <UL>
     * <LI>Lavadoras</LI>
     * <LI>Lavavajillas</LI>
     * <LI>Congeladores</LI>
     * <LI>Hornos</LI>
     * <LI>Secadoras</LI>
     * <LI>Campanas</LI>
     * <LI>Frigoríficos</LI>
     * <LI>Vitrocerámicas</LI>
     * </UL>
     */
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
