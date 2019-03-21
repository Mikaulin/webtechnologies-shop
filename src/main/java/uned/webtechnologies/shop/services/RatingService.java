package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Brand;
import uned.webtechnologies.shop.inmemorydb.model.Category;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.repository.ProductRepository;
import uned.webtechnologies.shop.inmemorydb.repository.RatingRepository;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private ProductRepository productRepository;





}

