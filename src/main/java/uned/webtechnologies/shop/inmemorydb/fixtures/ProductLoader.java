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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service

public class ProductLoader implements ILoader {

    private Logger log = LoggerFactory.getLogger(ProductLoader.class);
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public ProductLoader(ProductRepository productRepository, CategoryRepository categoryRepository, BrandRepository brandRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void load() {
        List<Brand> brandList = this.brandRepository.findAll();
        List<Category> categoryList = this.categoryRepository.findAll();

        ArrayList<Product> products = new ArrayList<>(
                Arrays.asList(
                        new Product(20, "Frigorifico comby siemens", "Frigorifico combi No frost. Acabado en acero inoxidable ", "/electro/004_big.jpg", 1500, 30, 2000, 700, 550, true, brandList.get(0), categoryList.get(1)),
                        new Product(30, "Placa vitroceramica TB 6315 (Electrica - 60 cm - Negro)", "Tres focos de calor. Marco de acero inoxidable", "/electro/003_big.jpg", 423, 15, 10, 500, 500, true, brandList.get(2), categoryList.get(2)),
                        new Product(15, "Frigorifico combi RB37K6033SS/EF", "Frigorifico combi con sistema No Frost", "/electro/004_big.jpg", 900, 17, 1900, 550, 550, true, brandList.get(3), categoryList.get(0)),
                        new Product(17, "Lavadora F4J6JY0W (10 kg - 1400 rpm - Blanco)", "5 programas de lavado", "/electro/001_big.jpg", 370, 15, 780, 575, 550, true, brandList.get(2), categoryList.get(0)),
                        new Product(42, "Horno SurroundCook BPS331120M (71 L - 59.5 cm - Pirolitico - Inox)", "Facil limpieza, cristal extraible. Motor giratorio para asados", "/electro/005_big.jpg", 450, 12, 500, 530, 540, false, brandList.get(0), categoryList.get(0)),
                        new Product(23, "Lavasecadora WVH28 1EP (4/7 kg - 1400 rpm - Blanco)", "7 programas de lavado. 5 programas de secado. Bomba de calor", "/electro/006_big.jpg", 375, 10, 700, 540, 530, false, brandList.get(3), categoryList.get(0)),
                        new Product(55, "Lavavajillas 3VS502BP (12 cubiertos - 60 cm - Blanco)", "7 programas de lavado. Encendido programable,Integrable", "/electro/007_big.jpg", 420, 10, 700, 550, 530, false, brandList.get(4), categoryList.get(0)),
                        new Product(60, "Frigorífico combi LI8 FF2I WH", "Disponible en blanco y acero inoxidable", "/electro/008_big.jpg", 50, 0, 1900, 570, 580, false, brandList.get(5), categoryList.get(1))
                )
        );
        productRepository.save(products);
        log.info("Productos cargados en DataBase: " + products.size());
    }


}
