package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.Rating;
import uned.webtechnologies.shop.inmemorydb.model.RatingValue;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.model.persistense.ProductUserRating;
import uned.webtechnologies.shop.inmemorydb.repository.RatingRepository;

import java.util.ArrayList;
import java.util.List;

/**Servicio que implementa la lógica de negócio del MVC entre el controlador y las valoraciones de productos del modelo
 * @see RatingRepository
 * @see Rating
 * @see ProductService
 */
@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private ProductService productService;

    /**Método que devuelve todos los productos con un determinado rating
     * @param rating Rating sobre el que se desean obtener los productos
     * @return Lista de productos con un Rating concreto
     * @see Product
     * @see ProductService
     */
    public List<Product> getProductsByRating(int rating) {
        List<Product> products = this.productService.getProducts();
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (getProductRating(p.getId()) == rating) {
                result.add(p);
            }
        }
        return result;
    }

    /**Metodo que define o actualiza el Rating de un producto.
     * @param user Usuario que realiza la valoración del producto
     * @param product Producto que se desea valorar
     * @param ratingValue Valoración que se desea asignar
     */
    public void setProductRating(User user, Product product, RatingValue ratingValue) {
        Rating rating = new Rating();
        ProductUserRating productUserRating = new ProductUserRating();
        productUserRating.setProductId(product.getId());
        productUserRating.setUserId(user.getId());
        rating.setProductUserRating(productUserRating);
        rating.setRatingValue(ratingValue);
        this.ratingRepository.save(rating);
    }

    /** Metodo que devuelve el valor medio de todas las valoraciónes de un producto.
     * @param id Identificador único sobre el que se obtiene la valoración media
     * @return Número entero con la valoración media del producto
     * @see Product
     */
    public int getProductRating(long id) {
        List<Rating> ratings = this.ratingRepository.getRatingsByProductUserRating_ProductId(id);
        return getRatingAVG(ratings);
    }


    private int getRatingAVG(List<Rating> ratings) {
        if (ratings.isEmpty()) return 0;
        float total = 0;
        int count = ratings.size();

        for (Rating r : ratings) {
            total = total + r.getRatingValue().getValue();
        }

        return Math.round(total / count);
    }
}