package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Brand;
import uned.webtechnologies.shop.inmemorydb.repository.BrandRepository;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;


    public List<Brand> getBrands() {
        return this.brandRepository.findAll();
    }


}
