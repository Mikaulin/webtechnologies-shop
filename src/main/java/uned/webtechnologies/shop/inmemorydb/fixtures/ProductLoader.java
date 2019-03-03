package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.repository.ProductRepository;
import java.util.List;

@Service
public class ProductLoader implements IProductLoader {

    private Logger log2 = LoggerFactory.getLogger("Application");
    private final ProductRepository productRepository;

    @Autowired
    public ProductLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void load() {
        Product product1 = new Product(1L, "/electro/002_big.jpg", "LG", "Frigor&iacute;fico Combi GBB60SWGFS", 799.99, 599.99, 200.00, 33);
        Product product2 = new Product(2L, "/electro/003_big.jpg", "TEKA", "Placa vitrocer&aacute;mica TB 6315 (El&eacute;ctrica - 60 cm - Negro)", 219.99, 181.82, 38.17, 33);
        Product product3 = new Product(3L, "/electro/004_big.jpg", "SAMSUNG", "Frigor&iacute;fico combi RB37K6033SS/EF", 849.99, 699.99, 150.00, 33);
        Product product4 = new Product(4L, "/electro/001_big.jpg", "LG", "Lavadora F4J6JY0W (10 kg - 1400 rpm - Blanco)", 629.99, 520.69, 109.30, 33);

        Product product5 = new Product(5L, "/electro/005.jpg", "AEG", "Horno SurroundCook BPS331120M (71 L - 59.5 cm - Pirol&iacute;tico - Inox)", 199.99, 179.99, 20.00, 33);
        Product product6 = new Product(6L, "/electro/006.jpg", "BOSCH", "Lavasecadora WVH28 1EP (4/7 kg - 1400 rpm - Blanco)", 999.99, 749.99, 250.00, 33);
        Product product7 = new Product(7L, "/electro/007.jpg", "BALAY", "Lavavajillas 3VS502BP (12 cubiertos - 60 cm - Blanco)", 349.99, 299.99, 50.00, 33);
        Product product8 = new Product(8L, "/electro/008.jpg", "INDISET", "Frigor&iacute;fico combi LI8 FF2I WH", 469.99, 399.99, 70.00, 33);

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

    @Override
    public List<Product> productList() {
        return null;
    }

    @Override
    public void productDelete(Long id) {

    }

    @Override
    public void productAdd(Product product) {

    }

    @Override
    public Long productCount() {
        return null;
    }
}
