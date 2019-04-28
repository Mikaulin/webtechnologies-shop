package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Promotion;
import uned.webtechnologies.shop.inmemorydb.repository.PromotionRepository;

import java.util.GregorianCalendar;

@Service
public class PromotionLoader implements ILoader {

    private Logger log = LoggerFactory.getLogger("Application");
    private final PromotionRepository promotionRepository;

    @Autowired
    public PromotionLoader(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public void load() {

        Promotion prom = new Promotion();
        prom.setDescription("Rebajas del 15% en electrodomésticos agosto 2018");
        prom.setName("Rebajas 15% Agosto 2018");
        prom.setStartDate(new GregorianCalendar(2018, 7, 1));
        prom.setEndDate(new GregorianCalendar(2018, 7, 31));
        prom.setDiscount(15);
        promotionRepository.save(prom);

        Promotion navidad18 = new Promotion();
        navidad18.setDescription("Campaña dto 20% productos Navidad 2018");
        navidad18.setName("Descuento 20% Navidad 2018");
        navidad18.setStartDate(new GregorianCalendar(2018, 11, 1));
        navidad18.setEndDate(new GregorianCalendar(2018, 11, 21));
        navidad18.setDiscount(20);
        promotionRepository.save(navidad18);

        Promotion diaDelPadre = new Promotion();
        diaDelPadre.setDescription("Especial día del padre 2019 25% descuento");
        diaDelPadre.setName("Especial 20% día del padre");
        diaDelPadre.setStartDate(new GregorianCalendar(2019, 2, 19));
        diaDelPadre.setEndDate(new GregorianCalendar(2019, 2, 21));
        diaDelPadre.setDiscount(25);
        promotionRepository.save(diaDelPadre);

        Promotion d30 = new Promotion();
        d30.setDescription("Descuento del 30 en algunos productos");
        d30.setName("Superdescuento del 30%");
        d30.setStartDate(new GregorianCalendar(2019, 4, 5));
        d30.setEndDate(new GregorianCalendar(2019, 6, 20));
        d30.setDiscount(30);
        promotionRepository.save(d30);

        Promotion d20 = new Promotion();
        d20.setDescription("Descuento del 20% en primavera 2019");
        d20.setName("Descuento 20% primavera 2019");
        d20.setStartDate(new GregorianCalendar(2019, 1, 21));
        d20.setEndDate(new GregorianCalendar(2019, 4, 21));
        d20.setDiscount(20);
        promotionRepository.save(d20);

        Promotion d15Z = new Promotion();
        d15Z.setDescription("Descuento del 15% todos los productos");
        d15Z.setName("Rebajas 15% productos");
        d15Z.setStartDate(new GregorianCalendar(2019, 0, 1));
        d15Z.setEndDate(new GregorianCalendar(2019, 6, 30));
        d15Z.setDiscount(15);
        promotionRepository.save(d15Z);


        log.info("Promociones cargadas en  DataBase: " + promotionRepository.count());
    }
}
