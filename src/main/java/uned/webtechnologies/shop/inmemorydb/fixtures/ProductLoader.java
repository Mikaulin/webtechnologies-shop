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
import uned.webtechnologies.shop.inmemorydb.repository.PromotionRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase encargada de cargar Productos en el respositorio de categorias.
 *
 * @see ProductRepository
 * @see Product
 */


@Service
public class ProductLoader implements ILoader {
    private Logger log = LoggerFactory.getLogger(ProductLoader.class);
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final PromotionRepository promotionRepository;

    /**
     * Construye un cargador de productos y le asigna los repositorios necesarios para construir las instancias de productos y guardarlas.
     *
     * @param productRepository   Repositorio de productos en el que guardar las instancias de productos.
     * @param categoryRepository  Repositorio de categorias del que obtener las categorías existentes.
     * @param brandRepository     Respositorio de marcas del que obtener las marcas existentes.
     * @param promotionRepository Repositorio de promociones del que obtener las promociones existentes.
     */
    @Autowired
    public ProductLoader(ProductRepository productRepository,
                         CategoryRepository categoryRepository,
                         BrandRepository brandRepository,
                         PromotionRepository promotionRepository
    ) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
        this.promotionRepository = promotionRepository;
    }

    /**
     * Este metodo obtiene las marcas,categorais y promociones de sus correspondientes respositorios,
     * crea algunos productos de ejemplo asignandoles algunas de las marcas,categorias y promociones obtenidas
     * y guarda los productos en su correspondiente repositorio.
     */
    @Override
    public void load() {
        List<Brand> brandList = this.brandRepository.findAll();
        List<Category> categoryList = this.categoryRepository.findAll();

        ArrayList<Product> products = new ArrayList<>(
                Arrays.asList(
                        new Product(60, "Lavadora L6FBI824U (8 kg - 1200 rpm - Blanco)", "Cuba Acero Inox., A+++, 52 L, 10 programas lavado", "L001.jpg", 419.99, 850, 600, 575, false, brandList.get(4), categoryList.get(0)),
                        new Product(60, "Lavadora L6FBG144 (10 kg - 1400 rpm - Blanco)", "2200 W, A+++, 57 L, Programa rápido", "L002.jpg", 599.99, 850, 600, 630, false, brandList.get(4), categoryList.get(0)),
                        new Product(60, "Lavadora F4J6VY2W (9 kg - 1400 rpm - Blanco)", "Motor Inverter, Opción media carga, 14 programas lavado", "L003.jpg", 599.99, 850, 600, 560, false, brandList.get(1), categoryList.get(0)),
                        new Product(5, "Lavadora 3TS775BE (7 kg - 1200 rpm - Blanco)", "Garantía 2 años, Eficiencia energética A+++", "L004.jpg", 399.99, 848, 598, 550, true, brandList.get(0), categoryList.get(0)),
                        new Product(60, "Lavasecadora XWDE 140 X (6/8 kg - 1400 rpm - Blanco)", "1850 W, A, 60 L, Tecn. Innex, Cuba Poliplex, Pantalla LED", "L005.jpg", 499.99, 850, 595, 540, false, brandList.get(7), categoryList.get(0)),
                        new Product(60, "Lavadora WM14U940EU (10 kg - 1400 rpm - Blanco)", "Cuba Acero Inox., A+++, 16 programas lavado, Wifi, 2050 W.", "L006.jpg", 1438, 848, 598, 622, false, brandList.get(3), categoryList.get(0)),

                        new Product(60, "Frigorífico combi RCB63426TX Plata", "A++ , No Frost , Refr. 220 L, Cong. 91 L", "F001.jpg", 899.99, 1840, 595, 647, true, brandList.get(4), categoryList.get(6)),
                        new Product(60, "Frigorífico americano GMJ936NSHV", "A+ , No Frost , Refr. 371 L, Cong. 200 L", "F002.jpg", 2530, 1790, 912, 758, false, brandList.get(1), categoryList.get(6)),
                        new Product(0, "Frigorífico 2 puertas 3FF3450MI", "A+ , No Frost , Refr. 214 L, Cong. 64 L", "F003.jpg", 770.99, 1710, 600, 600, false, brandList.get(0), categoryList.get(6)),
                        new Product(60, "Frigorífico combi KGN36NW3B blanco", "A++ , No Frost , Refr. 215 L, Cong. 87 L", "F004.jpg", 599.99, 1860, 600, 620, false, brandList.get(5), categoryList.get(6)),
                        new Product(60, "Frigorífico combi NFL 435", "A++ , No Frost , Refr. 215 L, Cong. 73 L", "F005.jpg", 570.99, 1900, 2010, 635, false, brandList.get(2), categoryList.get(6)),

                        new Product(60, "Lavavajillas SMS25FW05E (14 cubiertos - 60 cm - Blanco)", "930 W, A++, 5 programas, 9.5 L/ciclo", "LV001.jpg", 471.99, 845, 600, 600, false, brandList.get(5), categoryList.get(1)),
                        new Product(60, "Lavavajillas 3VS502IP (12 cubiertos - 60 cm - Inox)", "2400 W, A+, 5 programas, 11,7 L/ciclo, secado dinámico", "LV002.jpg", 399.99, 845, 600, 600, true, brandList.get(0), categoryList.get(1)),
                        new Product(60, "Lavavajillas  LP8 825 (14 cubiertos - 60 cm - Inox)", "2100 W, A++, 6 programas, 11 L/ciclo, color Inox.", "LV003.jpg", 449.99, 845, 600, 610, false, brandList.get(2), categoryList.get(1)),
                        new Product(60, "Lavavajillas FFB64706PM (15 cubiertos - 59.6 cm - Inox)", "2200 W, A+++, 11 L/ciclo, 8 programas, aqua stop", "LV004.jpg", 779.99, 850, 596, 610, false, brandList.get(4), categoryList.get(1)),
                        new Product(60, "Lavavajillas integrable ZDT24004FA (13 cubiertos - 59.6 cm)", "1950 W, 5 programas, 9,9 L/ciclo, color negro", "LV005.jpg", 459.99, 818, 596, 555, false, brandList.get(8), categoryList.get(1)),

                        new Product(60, "Placa de inducción HK674400FB (Eléctrica - 59 cm - Negro)", "7400 W, 4 placas, sup. vidrio, control táctil, 14 niv. Potencia", "P001.jpg", 849.99, 55, 590, 520, false, brandList.get(4), categoryList.get(7)),
                        new Product(60, "Placa vitrocerámica Z6123IOK (Eléctrica - 59 cm - Negro)", "2700 W. 3 placas, sup. Vidrio, control táctil, quemador radiante", "P002.jpg", 209.99, 38, 590, 520, true, brandList.get(8), categoryList.get(7)),
                        new Product(60, "Placa de inducción PID631BB3E (Eléctrica - 59.2 cm)", "3 placas, sup.vidrio, quemador inducción, color negro", "P003.jpg", 489.99, 51, 592, 522, false, brandList.get(5), categoryList.get(7)),
                        new Product(60, "Placa de inducción 3EB865AQ (Eléctrica - 59.2 cm)", "3 placas, sup. vidrio, quemador inducción, 2 años garantía", "P004.jpg", 499.99, 51, 592, 522, false, brandList.get(0), categoryList.get(7)),

                        new Product(60, "Placa de inducción 3EB980AU (Eléctrica - 79.1 cm)", "2 placas, quemador inducción, fun. memoria, bloqueo seg.", "P005.jpg", 1099, 51, 791, 522, false, brandList.get(0), categoryList.get(7)),


                        new Product(60, "Horno ZOP37922XU (57 L - 59.4 cm - Pirolítico - Inox)", "2515 W, A+, 9 programas, control digital, multifunción, grill electr.", "H001.jpg", 349.99, 590, 594, 560, false, brandList.get(8), categoryList.get(3)),
                        new Product(60, "Horno SteamCrisp BSE576321M (72 L - 59.6 cm - Hidrolítico - Inox)", "3380 W, A, 10 programas, visor digital, sonda térmica, grill electr.", "H002.jpg", 649.99, 596, 568, 580, false, brandList.get(4), categoryList.get(3)),
                        new Product(60, "Horno HS636GDS1 (71 L - 59.4 cm - Catalítico - Negro)", "3600 W,A, limpieza catalítico, vapor 100%, Deep-frozen, turbogrill", "H003.jpg", 1359, 595, 594, 548, false, brandList.get(6), categoryList.get(3)),
                        new Product(60, "Horno HR675GBS1 (71 L - 59.4 cm - Pirolítico - Inox)", "3600 W, A, 20 programas, control digital, multifunc., color inox.", "H004.jpg", 999.99, 595, 594, 548, true, brandList.get(6), categoryList.get(3)),
                        new Product(60, "Horno HLF 940 (77 L - 89 cm - Hidrolítico - Inox)", "3553 W, A, 9 programas, control digital, visor digital, grill electr.", "H005.jpg", 819.99, 480, 890, 558, false, brandList.get(2), categoryList.get(3)),

                        new Product(60, "Congelador vertical GSN33VL3P", "90 W, No frost, A++, 4 cestos, 2 años garantía, 225 L cap.", "C001.jpg", 821.99, 1760, 600, 650, false, brandList.get(5), categoryList.get(2)),
                        new Product(60, "Congelador vertical HSN36AI3P", "90 W, A++, No frost, Pantalla LCD, máquina hielos, 242 L cap.", "C002.jpg", 1019, 1860, 600, 650, false, brandList.get(5), categoryList.get(2)),
                        new Product(60, "Congelador Vertical No Frost ZFU25200WA", "160 W, A+, No frost, color blanco, 227 L cap.", "C003.jpg", 699.99, 1850, 595, 668, true, brandList.get(8), categoryList.get(2)),
                        new Product(60, "Congelador vertical TGF3 270 inox", "95 W, B, No frost, acero inox., 225 L cap.", "C004.jpg", 626.99, 1900, 595, 650, false, brandList.get(2), categoryList.get(2)),
                        new Product(60, "Congelador Vertical No Frost UI8 F1C W", "A+, color blanco, 2 años garantía,  260 L cap.", "C005.jpg", 499.99, 1875, 595, 630, false, brandList.get(7), categoryList.get(2)),

                        new Product(60, "Secadora T8DEE942 (9 kg - Bomba de Calor - Blanco)", "800 W, A++, 8 programas, pantalla LCD, func. antiarrugas", "S001.jpg", 899.99, 850, 600, 630, false, brandList.get(4), categoryList.get(4)),
                        new Product(60, "Secadora 3SC871B (7 kg - Condensación - Blanco)", "2800 W, B, 8 programas, pantalla táctil, func. antiarrugas", "S002.jpg", 359.99, 842, 598, 600, false, brandList.get(0), categoryList.get(4)),
                        new Product(60, "Secadora Bomba Calor WTG87239ES (8 kg - Bomba de Calor - Blanco)", "1000 W, A++, 10 programas, pantalla táctil, func. antiarrugas", "S003.jpg", 599.99, 599, 598, 580, false, brandList.get(5), categoryList.get(4)),
                        new Product(60, "Secadora DV90M6200CW/EC (9 kg - Bomba de Calor - Blanco)", "1000 W, A+++, 14 programas, pantalla LED, sensor secado, func. antiarrugas", "S004.jpg", 849.99, 850, 600, 650, true, brandList.get(3), categoryList.get(4)),
                        new Product(60, "Secadora TKS1 10 H (8 kg - Bomba de Calor - Blanco)", "650 W, A++, 12 programas, pantalla LED, func. antiarrugas", "S005.jpg", 649.99, 845, 595, 620, false, brandList.get(2), categoryList.get(4)),


                        new Product(60, "Campana Extraible DFT63AC50 60 cm", "146 W, D, 3 niv. potencia, ilum. LED, ruido 68 DB, 2 filtros antigrasa", "CP001.jpg", 129.99, 180, 598, 280, false, brandList.get(5), categoryList.get(5)),
                        new Product(60, "Campana Decorativa DWQ96DM50 90 cm", "220 W, A, mandos electr., color acero inox", "CP002.jpg", 399.99, 570, 750, 500, true, brandList.get(5), categoryList.get(5)),
                        new Product(60, "Campana integrable GFG-2", "180 W, 3 niv. potencia, ruido 58 DB, ilumin. LED, 1 filtro antigrasa", "CP003.jpg", 129.99, 175, 550, 310, false, brandList.get(2), categoryList.get(5)),
                        new Product(60, "Campana Pared DBB5660HM 60 cm", "265 W, A, 3 niv. potencia, ruido 36 DB, ilum. LED, camp. pared", "CP004.jpg", 399.99, 900, 598, 500, false, brandList.get(4), categoryList.get(5)),
                        new Product(60, "Campana Decoración BALAY 3BC694MX 90 cm", "100 W, C, 3 niv. potencia, ruido 65 DB, ilum. LED", "CP005.jpg", 219.99, 900, 900, 500, false, brandList.get(0), categoryList.get(5))


                )

        );

        long count = this.promotionRepository.count();
        for (Product p : products) {
            p.setPromotion(this.promotionRepository.findOne((long) Math.floor(Math.random() * count + 1)));

        }
        products.get(0).setPromotion(promotionRepository.findOne((long) 1));
        products.get(0).setPromotion(promotionRepository.findOne((long) 2));
        products.get(0).setPromotion(promotionRepository.findOne((long) 3));

        productRepository.save(products);
        log.info("Productos cargados en DataBase: " + products.size());
    }


}
