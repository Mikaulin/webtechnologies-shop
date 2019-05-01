package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Brand;
import uned.webtechnologies.shop.inmemorydb.repository.BrandRepository;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase encargada de cargar marcas en el repositorio de marcas.
 *
 * @see BrandRepository
 * @see Brand
 */

@Service
public class BrandLoader implements ILoader {

    private Logger log = LoggerFactory.getLogger("Application");
    private final BrandRepository brandRepository;

    /**
     * Construye un cargador asignandole su correspondiente repositorio
     *
     * @param brandRepository Repositorio de marcas.
     * @see BrandRepository
     */
    @Autowired
    public BrandLoader(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    /**
     * Metodo encargado de crear instancias de marcas y guardarlas en el repositorio.
     * <P>Marcas cargadas:</P>
     * <ul>
     * <li>BALAY</li>
     * <li>LG</li>
     * <li>TEKA</li>
     * <LI>SAMSUNG</LI>
     * <LI>AEG</LI>
     * <LI>BOSCH</LI>
     * <LI>SIEMENS</LI>
     * <LI>INDESIT</LI>
     * <LI>ZANUSSI</LI>
     * </ul>
     */
    @Override
    public void load() {
        ArrayList<Brand> brands = new ArrayList<>(
                Arrays.asList(
                        new Brand("BALAY"),
                        new Brand("LG"),
                        new Brand("TEKA"),
                        new Brand("SAMSUNG"),
                        new Brand("AEG"),
                        new Brand("BOSCH"),
                        new Brand("SIEMENS"),
                        new Brand("INDESIT"),
                        new Brand("ZANUSSI")
                )
        );
        brandRepository.save(brands);
        log.info("Marcas cargadas en DataBase: " + brands.size());
    }
}
