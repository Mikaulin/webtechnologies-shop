package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Brand;
import uned.webtechnologies.shop.inmemorydb.model.Category;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService{

    @Autowired
    private ProductRepository productRepository;


    public List<Product> getProducts() {
        return this.productRepository.findAll();
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

    public void add(Product product) {
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

//    public List<Product> getProductsByPromotionId(long id){ return this.productRepository.getProductByPromotionId(id); }

}