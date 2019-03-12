package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Brand;
import uned.webtechnologies.shop.inmemorydb.model.Category;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.ProductDetails;
import uned.webtechnologies.shop.inmemorydb.repository.BrandRepository;
import uned.webtechnologies.shop.inmemorydb.repository.CategoryRepository;
import uned.webtechnologies.shop.inmemorydb.repository.ProductRepository;


@Service

public class ProductLoader implements ILoader {

    private Logger log2 = LoggerFactory.getLogger("Application");
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
        Category raiz = new Category("raiz", null);
        categoryRepository.save(raiz);
        Category ge = new Category("Grandes electrodomesticos", raiz);
        categoryRepository.save(ge);
        Category fri = new Category("frigorificos", ge);
        categoryRepository.save(fri);
        Category vitro = new Category("vitroceramicas", raiz);
        categoryRepository.save(vitro);


        Brand balay = new Brand("BALAY");
        Brand lg = new Brand("LG");
        Brand teka = new Brand("TEKA");
        Brand samsung = new Brand("SAMSUNG");
        Brand aeg = new Brand("AEG");
        Brand bosch = new Brand("BOSCH");
        Brand indesit = new Brand("INDESIT");
        brandRepository.save(balay);
        brandRepository.save(lg);
        brandRepository.save(teka);
        brandRepository.save(samsung);
        brandRepository.save(aeg);
        brandRepository.save(bosch);
        brandRepository.save(indesit);

        Product product1 = new Product("Frigorifico comby siemens", "/electro/004_big.jpg", 100, balay, fri, new ProductDetails(2000, 900, 600),30,900);
        Product product2 = new Product("Placa vitrocer&aacute;mica TB 6315 (El&eacute;ctrica - 60 cm - Negro)", "/electro/003_big.jpg", 100, teka, vitro, new ProductDetails(5, 600, 500),20,450);
        Product product3 = new Product("Frigor&iacute;fico combi RB37K6033SS/EF", "/electro/004_big.jpg", 50, samsung, ge, new ProductDetails(2000, 600, 500),30,875);
        Product product4 = new Product("Lavadora F4J6JY0W (10 kg - 1400 rpm - Blanco)", "/electro/001_big.jpg", 50, lg, ge, new ProductDetails(700, 570, 480),15,625);
        Product product5 = new Product("Horno SurroundCook BPS331120M (71 L - 59.5 cm - Pirol&iacute;tico - Inox)", "/electro/005_big.jpg", 50, aeg, raiz, new ProductDetails(680, 570, 480),10,1000);
        Product product6 = new Product("Lavasecadora WVH28 1EP (4/7 kg - 1400 rpm - Blanco)", "/electro/006_big.jpg", 50, bosch, ge, new ProductDetails(680, 570, 480),15,700);
        Product product7 = new Product("Lavavajillas 3VS502BP (12 cubiertos - 60 cm - Blanco)", "/electro/007_big.jpg", 50, balay, ge, new ProductDetails(700, 570, 480),35,450);
        Product product8 = new Product("Frigor&iacute;fico combi LI8 FF2I WH", "/electro/008_big.jpg", 50, indesit, fri, new ProductDetails(1900, 570, 480),40,900);


        brandRepository.save(balay);


        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
        productRepository.save(product7);
        productRepository.save(product8);


        log2.info("Productos cargados en DataBase: " + productRepository.count());

    }


}
