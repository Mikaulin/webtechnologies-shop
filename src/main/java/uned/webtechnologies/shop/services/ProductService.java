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

@Service
public class ProductService{

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    public Set<Promotion> getPromotionsByProductId(long id){
        Product product=this.productRepository.getOne(id);
        return product.getPromotions();
    }
    public Product getProduct(long id){
        return this.productRepository.getOne(id);
    }

    public List<Product> getProductsByCategory(Category category){
        return this.productRepository.getProductByCategory(category);
    }
    public List<Product> getProductsByBrand(Brand brand){
        return this.productRepository.getProductByBrand(brand);
    }

    public List<Product> getFeaturedProducts(){
        return this.productRepository.getProductByFeaturedTrue();
    }

    public void save(Product product) {
        this.productRepository.save(product);
    }

    public Long count() {
        return this.productRepository.count();
    }

    public List<Product> getProductsByBrandId(long id){
        return this.productRepository.getProductByBrandId(id);
    }

    public List<Product> getProductsByCategoryId(long id){
        return this.productRepository.getProductByCategoryId(id);
    }

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

        if(!product.getPhoto().isEmpty()) {
            updatedProduct.setPhoto(product.getPhoto());
        }
        save(updatedProduct);
    }

}