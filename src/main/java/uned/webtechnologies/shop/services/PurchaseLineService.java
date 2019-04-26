package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Cart;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.PurchaseLine;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.repository.PurchaseLineRepository;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class PurchaseLineService {

    @Autowired
    private PurchaseLineRepository purchaseLineRepository;

    public PurchaseLineService() {
    }
    public List<PurchaseLine> getPurchasesByDate(Calendar date){
        return this.purchaseLineRepository.findAllByDate(date);
    }
    public PurchaseLine getOne(long id){
        return this.purchaseLineRepository.findOne(id);
    }

    public List<PurchaseLine> getAllPurchases(){
        return this.purchaseLineRepository.findAll();
    }


    public void saveRandom(PurchaseLine purchaseLine) {purchaseLineRepository.save(purchaseLine);}


    private void checkQuantity(Product product,int count) throws RuntimeException{

        if(product.getCount()<count) throw new RuntimeException("No hay suficientes unidades del producto : "+product.getName()+"\n" +
                "Unidades solicitadas ="+count+"\n" +
                "Unidades disponibles = "+product.getCount());
    }

    @Transactional
    public void save(PurchaseLine purchaseLine) {
        Product product=purchaseLine.getProduct();
        int count=purchaseLine.getCount();
        int productCount=product.getCount();

        checkQuantity(product,count);
        Calendar today=new GregorianCalendar();
        today.getTime();
        purchaseLine.setDate(today);
        product.setCount(productCount-count);
        purchaseLineRepository.save(purchaseLine);

    }

    @Transactional
    public void returnPurchase(PurchaseLine purchaseLine) {
        Product product=purchaseLine.getProduct();
        int count=purchaseLine.getCount();
        int productCount=product.getCount();
        product.setCount(productCount+count);
        purchaseLineRepository.delete(purchaseLine);

    }

    @Transactional
    public void saveCarts(List<Cart> carts)  {
        PurchaseLine purchase;
        for (Cart cart : carts
        ) {
            purchase = new PurchaseLine();
            purchase.setProduct(cart.getProduct());
            purchase.setUnitPrice(cart.getUnitPrice());
            purchase.setCount(cart.getCount());
            purchase.setPurchasePrice(cart.getCartPrice());
            purchase.setUser(cart.getUser());
            this.save(purchase);


        }
    }
    public long count(){
        return this.purchaseLineRepository.count();
    }

    public List<PurchaseLine> getPurchaseLines(User user){
        return this.purchaseLineRepository.findByUser(user);
    }


}
