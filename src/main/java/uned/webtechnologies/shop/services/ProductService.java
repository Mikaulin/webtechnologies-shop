package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Brand;
import uned.webtechnologies.shop.inmemorydb.model.Category;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.Promotion;
import uned.webtechnologies.shop.inmemorydb.repository.ProductRepository;

import java.util.List;
import java.util.Set;

/**
 * Servicio que implementa la lógica de negócio del MVC entre el controlador y las Productos del modelo
 *
 * @see ProductRepository
 * @see Product
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Método que devuelve los productos del repositorio
     *
     * @return Lista de productos del repositorio
     * @see ProductRepository
     * @see Product
     */
    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    /**
     * Método que obtiene las promociónes asignadas a un producto del repositorio
     *
     * @param id Identificador único del producto sobre el que se quieren obtener las promociones asignadas
     * @return Conjunto de promociones asignadas a un producto en concreto.
     * @see ProductRepository
     * @see Product
     * @see Promotion
     */
    public Set<Promotion> getPromotionsByProductId(long id) {
        Product product = this.productRepository.getOne(id);
        return product.getPromotions();
    }

    /**
     * Método que devuelve un producto del repositorio
     *
     * @param id Identificador único del producto que se solicita
     * @return Producto concreto
     * @see ProductRepository
     * @see Product
     */
    public Product getProduct(long id) {
        return this.productRepository.getOne(id);
    }


    /**
     * Método que devuelve todos los productos destacados del repositorio
     *
     * @return Lista de productos destacados
     * @see ProductRepository
     * @see Product
     */
    public List<Product> getFeaturedProducts() {
        return this.productRepository.getProductByFeaturedTrue();
    }

    /**
     * Método que guarda o actualiza un producto en el repositorio
     *
     * @param product Producto que se quiere guardar o actualizar
     * @see ProductRepository
     * @see Product
     */
    public void save(Product product) {
        this.productRepository.save(product);
    }

    /**
     * Método que devuelve un numero que indica la cantidad total de productos existentes en el repositorio
     *
     * @return Número con la cantidad total de productos existentes en el repositorio
     * @see ProductRepository
     * @see Product
     */
    public Long count() {
        return this.productRepository.count();
    }

    /**
     * Método que devuelve todos los productos del repositorio que pertenezcan a una marca concreta
     *
     * @param id Identificador único de la marca a la que pertenecen los productos que se desean
     * @return Lista de productos que pertenecen a una marca concreta
     * @see ProductRepository
     * @see Product
     * @see Brand
     */
    public List<Product> getProductsByBrandId(long id) {
        return this.productRepository.getProductByBrandId(id);
    }

    /**
     * Método que devuelve todos los productos del repositorio que pertenezcan a una categoría concreta
     *
     * @param id Identificador único de la categoría a la que pertenecen los productos que se desean
     * @return Lista de productos que pertenecen a una categoría concreta
     * @see ProductRepository
     * @see Product
     * @see Category
     */
    public List<Product> getProductsByCategoryId(long id) {
        return this.productRepository.getProductByCategoryId(id);
    }

    /**
     * Método que se encarga de actualizar un producto en el repositorio
     *
     * @param id      Identificador único del producto que se desea actualizar
     * @param product Producto con la nueva información
     * @see ProductRepository
     * @see Product
     */
    public void update(long id, Product product) {
        Product updatedProduct = getProduct(id);
        updatedProduct.setName(product.getName());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setWidth(product.getWidth());
        updatedProduct.setHeight(product.getHeight());
        updatedProduct.setDepth(product.getDepth());
        updatedProduct.setCategory(product.getCategory());
        updatedProduct.setBrand(product.getBrand());
        updatedProduct.setCount(product.getCount());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setFeatured(product.isFeatured());
        updatedProduct.setDeleted(product.isDeleted());
        updatedProduct.setPromotions(product.getPromotions());

        if (!product.getPhoto().isEmpty()) {
            updatedProduct.setPhoto(product.getPhoto());
        }
        save(updatedProduct);
    }

}