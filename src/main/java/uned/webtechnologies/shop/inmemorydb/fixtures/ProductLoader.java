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

        Category ge = new Category("Grandes electrodomesticos");
        categoryRepository.save(ge);
        Category fri = new Category("frigorificos");
        categoryRepository.save(fri);
        Category vitro = new Category("vitroceramicas");
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

        Product product1 = new Product(20,"Frigorifico comby siemens","Frigorifico combi No frost. Acabado en acero inoxidable ", "/electro/004_big.jpg",1500,30,2000,700,550,balay,fri);
        Product product2 = new Product(30,"Placa vitroceramica TB 6315 (Electrica - 60 cm - Negro)","Tres focos de calor. Marco de acero inoxidable", "/electro/003_big.jpg", 423,15,10,500,500, teka, vitro);
        Product product3 = new Product(15,"Frigorifico combi RB37K6033SS/EF","Frigorifico combi con sistema No Frost","/electro/004_big.jpg",900,17,1900,550,550, samsung, ge);
        Product product4 = new Product(17,"Lavadora F4J6JY0W (10 kg - 1400 rpm - Blanco)","5 programas de lavado","/electro/001_big.jpg",370,15,780,575,550, lg, ge);
        Product product5 = new Product(42,"Horno SurroundCook BPS331120M (71 L - 59.5 cm - Pirolitico - Inox)","Facil limpieza, cristal extraible. Motor giratorio para asados","/electro/005_big.jpg",450, 12,500,530,540,aeg,ge);
        Product product6 = new Product(23,"Lavasecadora WVH28 1EP (4/7 kg - 1400 rpm - Blanco)","7 programas de lavado. 5 programas de secado. Bomba de calor","/electro/006_big.jpg",375,10, 700,540,530,bosch, ge);
        Product product7 = new Product(55,"Lavavajillas 3VS502BP (12 cubiertos - 60 cm - Blanco)","7 programas de lavado. Encendido programable,Integrable","/electro/007_big.jpg",420,10,700,550,530, balay, ge);
        Product product8 = new Product(60,"Frigorífico combi LI8 FF2I WH","Disponible en blanco y acero inoxidable","/electro/008_big.jpg", 50,0,1900,570,580,indesit, fri);



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
