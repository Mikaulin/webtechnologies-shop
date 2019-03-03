package uned.webtechnologies.shop.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
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


    public void productDelete(Long id) {

        this.productRepository.delete(id);
    }


    public void productAdd(Product product) {

        this.productRepository.save(product);
    }


    public Long productCount() {

        return this.productRepository.count();
    }
}

