package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.PurchaseLine;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.repository.ProductRepository;
import uned.webtechnologies.shop.inmemorydb.repository.UserRepository;
import uned.webtechnologies.shop.services.PurchaseLineService;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


@Service
public class PurchaseLinesLoader implements ILoader {


    private Logger log = LoggerFactory.getLogger("Application");
    private final PurchaseLineService purchaseLineService;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;


    @Autowired
    public PurchaseLinesLoader(PurchaseLineService purchaseLineService, UserRepository userRepository, ProductRepository productRepository) throws ParseException {
        this.purchaseLineService = purchaseLineService;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void load() {
        {
            List<User> userList = this.userRepository.findAll();
            List<Product> productList = this.productRepository.findAll();

            int id;
            PurchaseLine line;
            int count;


            for (User user : userList) {
                for (int s = 0; s < 5; s++) {
                    line = new PurchaseLine();
                    Calendar today = new GregorianCalendar(2019, 3, (int) Math.floor(Math.random() * 10));
                    id = (int) Math.floor(Math.random() * this.productRepository.count());

                    count = (int) Math.floor(Math.random() * 4);
                    if (count == 0) {
                        count++;
                    }
                    line.setDate(today);
                    line.setCount(count);
                    line.setUser(user);
                    line.setProduct(productList.get(id));
                    line.setUnitPrice(productList.get(id).getFinalPrice());
                    line.setPurchasePrice(productList.get(id).getFinalPrice()*count);


                    this.purchaseLineService.saveRandom(line);

                }
            }
        }
        log.info("Compras cargadas en DataBase: " + this.purchaseLineService.count());
    }


}

