package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Clase encargada de llamar a todos los cargadores de ejemplos
 */
@Component
public class FixturesLoader {
    private RoleLoader roleLoader;
    private UserLoader userLoader;
    private BrandLoader brandLoader;
    private CategoryLoader categoryLoader;
    private PromotionLoader promotionLoader;
    private ProductLoader productLoader;
    private RatingLoader ratingLoader;
    private RatingValueLoader ratingValueLoader;
    private PurchaseLinesLoader purchaseLinesLoader;
    private PhotoLoader photoLoader;


    /**
     * Construye el cargador de cargadores
     *
     * @param roleLoader          Cargador de roles
     * @param userLoader          Cargador de usuarios
     * @param brandLoader         Cargador de marcas
     * @param categoryLoader      Cargador de categorias
     * @param productLoader       Cargador de productos
     * @param ratingValueLoader   Cargador de RatingValues
     * @param ratingLoader        Cargador de Ratings
     * @param promotionLoader     Cargador de promociones
     * @param purchaseLinesLoader Cargador de lineas de compra
     */
    @Autowired
    public FixturesLoader(
            RoleLoader roleLoader,
            UserLoader userLoader,
            BrandLoader brandLoader,
            CategoryLoader categoryLoader,
            ProductLoader productLoader,
            RatingValueLoader ratingValueLoader,
            RatingLoader ratingLoader,
            PromotionLoader promotionLoader,
            PurchaseLinesLoader purchaseLinesLoader,
            PhotoLoader photoLoader

    ) {
        this.roleLoader = roleLoader;
        this.userLoader = userLoader;
        this.brandLoader = brandLoader;
        this.categoryLoader = categoryLoader;
        this.productLoader = productLoader;
        this.ratingValueLoader = ratingValueLoader;
        this.ratingLoader = ratingLoader;
        this.promotionLoader = promotionLoader;
        this.purchaseLinesLoader = purchaseLinesLoader;
        this.photoLoader=photoLoader;
    }

    /**
     * Método encargado de llamar al Método de carga de cada uno de los cargadores.
     */
    public void execute() {
        roleLoader.load();
        userLoader.load();
        brandLoader.load();
        categoryLoader.load();
        promotionLoader.load();
        photoLoader.load();
        productLoader.load();
        ratingValueLoader.load();
        ratingLoader.load();
        purchaseLinesLoader.load();

    }
}
