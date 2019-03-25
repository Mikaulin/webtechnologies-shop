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
                        new Product(20, "Lavadora L6FBI824U (8 kg - 1200 rpm - Blanco)", "Cuba Acero Inox., A+++, 52 L, 10 programas lavado", "/electro/L001.jpg", 419.99, 20, 850, 600, 575, true, brandList.get(4), categoryList.get(0)),
                        new Product(30, "Lavadora L6FBG144 (10 kg - 1400 rpm - Blanco)", "2200 W, A+++, 57 L, Programa rápido", "/electro/L002.jpg", 599.99, 20, 850, 600, 630, true, brandList.get(4), categoryList.get(0)),
                        new Product(15, "Lavadora F4J6VY2W (9 kg - 1400 rpm - Blanco)", "Motor Inverter, Opción media carga, 14 programas lavado", "/electro/L003.jpg", 599.99, 0, 850, 600, 560, true, brandList.get(1), categoryList.get(0)),
                        new Product(17, "Lavadora 3TS775BE (7 kg - 1200 rpm - Blanco)", "Garantía 2 años, Eficiencia energética A+++", "/electro/L004.jpg", 399.99, 0, 848, 598, 550, true, brandList.get(0), categoryList.get(0)),
                        new Product(42, "Lavasecadora Innex XWDE 140 X (6/8 kg - 1400 rpm - Blanco)", "1850 W, A, 60 L, Tecn. Innex, Cuba Poliplex, Pantalla LED", "/electro/L005.jpg", 499.99, 0, 850, 595, 540, true, brandList.get(7), categoryList.get(0)),
                        new Product(23, "Lavadora WM14U940EU (10 kg - 1400 rpm - Blanco)", "Cuba Acero Inox., A+++, 16 programas lavado, Wifi, 2050 W.", "/electro/L006.jpg", 1438, 20, 848, 598, 622, true, brandList.get(6), categoryList.get(0)),
                        new Product(55, "Lavadora WW80J5555FX/EC (8 kg - 1400 rpm - Negro)", "Pantalla LED, A+++, 14 programas lavado, Fuzzy Control", "/electro/L007.jpg", 499.99, 10, 850, 600, 550, true, brandList.get(3), categoryList.get(0)),

                        new Product(60, "Frigorífico combi RCB63426TX Plata", "A++ , No Frost , Refr. 220 L, Cong. 91 L", "/electro/F001.jpg", 899.99, 15, 1840, 595, 647, true, brandList.get(4), categoryList.get(6)),
                        new Product(60, "Frigorífico americano GMJ936NSHV", "A+ , No Frost , Refr. 371 L, Cong. 200 L", "/electro/F002.jpg", 2530, 0, 1790, 912, 758, true, brandList.get(1), categoryList.get(6)),
                        new Product(60, "Frigorífico 2 puertas 3FF3450MI", "A+ , No Frost , Refr. 214 L, Cong. 64 L", "/electro/F003.jpg", 770.99, 10, 1710, 600, 600, true, brandList.get(0), categoryList.get(6)),
                        new Product(60, "Frigorífico combi KGN36NW3B blanco", "A++ , No Frost , Refr. 215 L, Cong. 87 L", "/electro/F004.jpg", 599.99, 0, 1860, 600, 620, true, brandList.get(5), categoryList.get(6)),
                        new Product(60, "Frigorífico combi NFL 435", "A++ , No Frost , Refr. 215 L, Cong. 73 L", "/electro/F005.jpg", 570.99, 15, 1900, 2010, 635, true, brandList.get(2), categoryList.get(6)),

                        new Product(60, "Lavavajillas SMS25FW05E (14 cubiertos - 60 cm - Blanco)", "930 W, A++, 5 programas, 9.5 L/ciclo", "/electro/LV001.jpg", 471.99, 5, 845, 600, 600, true, brandList.get(5), categoryList.get(1)),
                        new Product(60, "Lavavajillas 3VS502IP (12 cubiertos - 60 cm - Inox)", "2400 W, A+, 5 programas, 11,7 L/ciclo, secado dinámico", "/electro/LV002.jpg", 399.99, 10, 845, 600, 600, true, brandList.get(0), categoryList.get(1)),
                        new Product(60, "Lavavajillas  LP8 825 (14 cubiertos - 60 cm - Inox)", "2100 W, A++, 6 programas, 11 L/ciclo, color Inox.", "/electro/LV003.jpg", 449.99, 20, 845, 600, 610, true, brandList.get(2), categoryList.get(1)),
                        new Product(60, "Lavavajillas FFB64706PM (15 cubiertos - 59.6 cm - Inox)", "2200 W, A+++, 11 L/ciclo, 8 programas, aqua stop", "/electro/LV004.jpg", 779.99, 15, 850, 596, 610, true, brandList.get(4), categoryList.get(1)),
                        new Product(60, "Lavavajillas integrable ZDT24004FA (13 cubiertos - 59.6 cm)", "1950 W, 5 programas, 9,9 L/ciclo, color negro", "/electro/LV005.jpg", 459.99, 12, 818, 596, 555, true, brandList.get(8), categoryList.get(1)),

                        new Product(60, "Placa de inducción HK674400FB (Eléctrica - 59 cm - Negro)", "7400 W, 4 placas, sup. vidrio, control táctil, 14 niv. Potencia", "/electro/P001.jpg", 849.99, 30, 55, 590, 520, true, brandList.get(4), categoryList.get(7)),
                        new Product(60, "Placa vitrocerámica Z6123IOK (Eléctrica - 59 cm - Negro)", "2700 W. 3 placas, sup. Vidrio, control táctil, quemador radiante", "/electro/P002.jpg", 209.99, 10, 38, 590, 520, true, brandList.get(8), categoryList.get(7)),
                        new Product(60, "Placa de inducción PID631BB3E (Eléctrica - 59.2 cm)", "3 placas, sup.vidrio, quemador inducción, color negro", "/electro/P003.jpg", 489.99, 0, 51, 592, 522, true, brandList.get(5), categoryList.get(7)),
                        new Product(60, "Placa de inducción 3EB865AQ (Eléctrica - 59.2 cm)", "3 placas, sup. vidrio, quemador inducción, 2 años garantía", "/electro/P004.jpg", 499.99, 0, 51, 592, 522, true, brandList.get(0), categoryList.get(7)),
                        new Product(60, "Placa de inducción 3EB980AU (Eléctrica - 79.1 cm)", "2 placas, quemador inducción, fun. memoria, bloqueo seg.", "/electro/P005.jpg", 1099, 0, 51, 791, 522, true, brandList.get(0), categoryList.get(7)),

                        new Product(60, "Horno ZOP37922XU (57 L - 59.4 cm - Pirolítico - Inox)", "2515 W, A+, 9 programas, control digital, multifunción, grill electr.", "/electro/H001.jpg", 349.99, 15, 590, 594, 560, true, brandList.get(8), categoryList.get(3)),
                        new Product(60, "Horno SteamCrisp BSE576321M (72 L - 59.6 cm - Hidrolítico - Inox)", "3380 W, A, 10 programas, visor digital, sonda térmica, grill electr.", "/electro/H002.jpg", 649.99, 18, 596, 568, 580, true, brandList.get(4), categoryList.get(3)),
                        new Product(60, "Horno HS636GDS1 (71 L - 59.4 cm - Catalítico - Negro)", "3600 W,A, limpieza catalítico, vapor 100%, Deep-frozen, turbogrill", "/electro/H003.jpg", 1359, 0, 595, 594, 548, true, brandList.get(6), categoryList.get(3)),
                        new Product(60, "Horno HR675GBS1 (71 L - 59.4 cm - Pirolítico - Inox)", "3600 W, A, 20 programas, control digital, multifunc., color inox.", "/electro/H004.jpg", 999.99, 0, 595, 594, 548, true, brandList.get(6), categoryList.get(3)),
                        new Product(60, "Horno HLF 940 (77 L - 89 cm - Hidrolítico - Inox)", "3553 W, A, 9 programas, control digital, visor digital, grill electr.", "/electro/H005.jpg", 819.99, 0, 480, 890, 558, true, brandList.get(2), categoryList.get(3)),

                        new Product(60, "Congelador vertical GSN33VL3P", "90 W, No frost, A++, 4 cestos, 2 años garantía, 225 L cap.", "/electro/C001.jpg", 821.99, 10, 1760, 600, 650, true, brandList.get(5), categoryList.get(2)),
                        new Product(60, "Congelador vertical HSN36AI3P", "90 W, A++, No frost, Pantalla LCD, máquina hielos, 242 L cap.", "/electro/C002.jpg", 1019, 0, 1860, 600, 650, true, brandList.get(5), categoryList.get(2)),
                        new Product(60, "Congelador Vertical No Frost ZFU25200WA", "160 W, A+, No frost, color blanco, 227 L cap.", "/electro/C003.jpg", 699.99, 15, 1850, 595, 668, true, brandList.get(8), categoryList.get(2)),
                        new Product(60, "Congelador vertical TGF3 270 inox", "95 W, B, No frost, acero inox., 225 L cap.", "/electro/C004.jpg", 626.99, 0, 1900, 595, 650, true, brandList.get(2), categoryList.get(2)),
                        new Product(60, "Congelador Vertical No Frost UI8 F1C W", "A+, color blanco, 2 años garantía,  260 L cap.", "/electro/C005.jpg", 499.99, 0, 1875, 595, 630, true, brandList.get(7), categoryList.get(2)),

                        new Product(60, "Secadora T8DEE942 (9 kg - Bomba de Calor - Blanco)", "800 W, A++, 8 programas, pantalla LCD, func. antiarrugas", "/electro/S001.jpg", 899.99, 23, 850, 600, 630, true, brandList.get(4), categoryList.get(4)),
                        new Product(60, "Secadora 3SC871B (7 kg - Condensación - Blanco)", "2800 W, B, 8 programas, pantalla táctil, func. antiarrugas", "/electro/S002.jpg", 359.99, 0, 842, 598, 600, true, brandList.get(0), categoryList.get(4)),
                        new Product(60, "Secadora Bomba Calor WTG87239ES (8 kg - Bomba de Calor - Blanco)", "1000 W, A++, 10 programas, pantalla táctil, func. antiarrugas", "/electro/S003.jpg", 599.99, 0, 599, 598, 580, true, brandList.get(5), categoryList.get(4)),
                        new Product(60, "Secadora DV90M6200CW/EC (9 kg - Bomba de Calor - Blanco)", "1000 W, A+++, 14 programas, pantalla LED, sensor secado, func. antiarrugas", "/electro/S004.jpg", 849.99, 0, 850, 600, 650, true, brandList.get(3), categoryList.get(4)),
                        new Product(60, "Secadora TKS1 10 H (8 kg - Bomba de Calor - Blanco)", "650 W, A++, 12 programas, pantalla LED, func. antiarrugas", "/electro/S005.jpg", 649.99, 0, 845, 595, 620, true, brandList.get(2), categoryList.get(4)),


                        new Product(60, "Campana Extraible DFT63AC50 60 cm", "146 W, D, 3 niv. potencia, ilum. LED, ruido 68 DB, 2 filtros antigrasa", "/electro/CP001.jpg", 129.99, 0, 180, 598, 280, true, brandList.get(5), categoryList.get(5)),
                        new Product(60, "Campana Decorativa DWQ96DM50 90 cm", "220 W, A, mandos electr., color acero inox", "/electro/CP002.jpg", 399.99, 0, 570, 750, 500, true, brandList.get(5), categoryList.get(5)),
                        new Product(60, "Campana integrable GFG-2", "180 W, 3 niv. potencia, ruido 58 DB, ilumin. LED, 1 filtro antigrasa", "/electro/CP003.jpg", 129.99, 0, 175, 550, 310, true, brandList.get(2), categoryList.get(5)),
                        new Product(60, "Campana Pared DBB5660HM 60 cm", "265 W, A, 3 niv. potencia, ruido 36 DB, ilum. LED, camp. pared", "/electro/CP004.jpg", 399.99, 20, 900, 598, 500, true, brandList.get(4), categoryList.get(5)),
                        new Product(60, "Campana Decoración BALAY 3BC694MX 90 cm", "100 W, C, 3 niv. potencia, ruido 65 DB, ilum. LED", "/electro/CP005.jpg", 219.99, 0, 900, 900, 500, true, brandList.get(0), categoryList.get(5))








                )
        );
        productRepository.save(products);
        log.info("Productos cargados en DataBase: " + products.size());
    }


}
