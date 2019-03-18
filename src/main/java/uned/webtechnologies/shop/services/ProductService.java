package uned.webtechnologies.shop.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import uned.webtechnologies.shop.inmemorydb.model.Category;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.repository.CategoryRepository;
import uned.webtechnologies.shop.inmemorydb.repository.ProductRepository;
import java.util.List;

@Service
public class ProductService{

    @Autowired
    private ProductRepository productRepository;


    public List<Product> getProducts() {

        return this.productRepository.findAll();
    }
    public Product getProduct(int id){
        return this.productRepository.getOne(id);
    }

    public List<Product> getProductsByCategory(Category category){
        return this.productRepository.getProductByCategory(category);
    }





    public void Add(Product product) {

        this.productRepository.save(product);
    }


    public Long Count() {

        return this.productRepository.count();
    }





}

