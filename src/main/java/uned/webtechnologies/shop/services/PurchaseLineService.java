package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Cart;
import uned.webtechnologies.shop.inmemorydb.model.PurchaseLine;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.repository.PurchaseLineRepository;

import java.util.*;
import java.util.List;

@Service
public class PurchaseLineService {
    @Autowired
    private PurchaseLineRepository purchaseLineRepository;

    public PurchaseLineService() {
    }

    public List<PurchaseLine> getAllPurchases(){
        return this.purchaseLineRepository.findAll();
    }


    public void saveRandom(PurchaseLine purchaseLine) {purchaseLineRepository.save(purchaseLine);}

    public void save(PurchaseLine purchaseLine) {
        Date today = new Date();
        today.getTime();
        purchaseLine.setDate(today);
        purchaseLineRepository.save(purchaseLine);
    }


    public void saveCarts(List<Cart> carts) {
        PurchaseLine purchase;
        for (Cart cart : carts
        ) {
            purchase = new PurchaseLine();
            purchase.setProduct(cart.getProduct());
            purchase.setUnitPrice(cart.getProduct().getFinalPrice());
            purchase.setCount(cart.getCount());
            purchase.setPurchasePrice(cart.getProduct().getFinalPrice() * cart.getCount());
            purchase.setUser(cart.getUser());
            this.save(purchase);


        }
    }
    public long count(){
        return this.purchaseLineRepository.count();
    }
    public List<PurchaseLine> getAllByDate(Date date){
        return this.purchaseLineRepository.findAllByDateEquals(date);
    }

    public List<PurchaseLine> getPurchaseLines(User user){
        return this.purchaseLineRepository.findByUser(user);
    }


}
