package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Brand;
import uned.webtechnologies.shop.inmemorydb.model.Promotion;
import uned.webtechnologies.shop.inmemorydb.repository.BrandRepository;
import uned.webtechnologies.shop.inmemorydb.repository.PromotionRepository;

import java.util.*;

@Service
public class PromotionLoader implements ILoader {

    private Logger log = LoggerFactory.getLogger("Application");
    private final PromotionRepository promotionRepository;

    @Autowired
    public PromotionLoader(PromotionRepository promotionRepository) {
        this.promotionRepository=promotionRepository;
    }

    @Override
    public void load() {

        Promotion prom=new Promotion();
        prom.setStartDate(new GregorianCalendar(2019,2,22));
        prom.setEndDate(new GregorianCalendar(10000,1,1));
        prom.setDescription("Descuento del 20 para siempre");
        prom.setName("Descuento del 20%");
        prom.setDiscount(20);
        promotionRepository.save(prom);
        Promotion diaDelPadre=new Promotion();
        diaDelPadre.setDescription("Especial día del padre 2019 25% descuento");
        diaDelPadre.setName("Especial 20% día del padre");
        diaDelPadre.setStartDate(new GregorianCalendar(2019,2,15));
        diaDelPadre.setEndDate(new GregorianCalendar(2019,2,21));
        diaDelPadre.setDiscount(25);
        promotionRepository.save(diaDelPadre);
        Promotion d30=new Promotion();
        d30.setDescription("Descuento del 30 para siempre");
        d30.setName("Superdescuento del 30%");
        d30.setStartDate(new GregorianCalendar(2019,2,15));
        d30.setEndDate(new GregorianCalendar(10000,2,21));
        d30.setDiscount(30);
        promotionRepository.save(d30);



        log.info("Promociones cargadas en DataBase: " + promotionRepository.count());
    }
}
