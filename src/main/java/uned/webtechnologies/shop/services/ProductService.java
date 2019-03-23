package uned.webtechnologies.shop.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import uned.webtechnologies.shop.inmemorydb.model.Brand;
import uned.webtechnologies.shop.inmemorydb.model.Category;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.Rating;
import uned.webtechnologies.shop.inmemorydb.repository.CategoryRepository;
import uned.webtechnologies.shop.inmemorydb.repository.ProductRepository;
import uned.webtechnologies.shop.inmemorydb.repository.RatingRepository;

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
        return this.productRepository.getProductsByCategory(category);
    }
    public List<Product> getProductsByBrand(Brand brand){
        return this.productRepository.getProductsByBrand(brand);
    }
    public List<Product> getProductsByBrandId(long id){
        return this.productRepository.getProductByBrandId(id);
    }

    public List<Product> getFeaturedProducts(){
        return this.productRepository.getProductsByFeaturedTrue();
    }


    public void add(Product product) {
        this.productRepository.save(product);
    }



    public Long count() {
        return this.productRepository.count();
    }
}

