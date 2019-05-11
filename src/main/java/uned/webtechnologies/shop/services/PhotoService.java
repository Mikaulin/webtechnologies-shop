package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uned.webtechnologies.shop.inmemorydb.model.Photo;


import uned.webtechnologies.shop.inmemorydb.repository.PhotoRepository;

import java.util.List;


@Service
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepository;


    public Photo getByUrl(String url){
        return this.photoRepository.getByUrl(url);
    }
    public List<Photo> getPhotos(){
        return this.photoRepository.findAll();
    }
}
















