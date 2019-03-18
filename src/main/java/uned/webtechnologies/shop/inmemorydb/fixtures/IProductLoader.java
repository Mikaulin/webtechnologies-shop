package uned.webtechnologies.shop.inmemorydb.fixtures;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import java.util.List;

public interface IProductLoader {

    void load();

    List<Product> productList();

    void productDelete(Long id);

    void productAdd(Product product);

    Long productCount();

}