package uned.webtechnologies.shop.inmemorydb.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Photo;

import uned.webtechnologies.shop.inmemorydb.repository.PhotoRepository;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase encargada de cargar fotos en el respositorio de categorias.
 */


@Service
public class PhotoLoader implements ILoader {

    private Logger log = LoggerFactory.getLogger("Application");
    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoLoader(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }


    @Override
    public void load() {
        ArrayList<Photo> photos = new ArrayList<>(
                Arrays.asList(
                        new Photo("L001.jpg"),
                        new Photo("L002.jpg"),
                        new Photo("L003.jpg"),
                        new Photo("L004.jpg"),
                        new Photo("L005.jpg"),
                        new Photo("L006.jpg"),
                        new Photo("F001.jpg"),
                        new Photo("F002.jpg"),
                        new Photo("F003.jpg"),
                        new Photo("F004.jpg"),
                        new Photo("F005.jpg"),
                        new Photo("LV001.jpg"),
                        new Photo("LV002.jpg"),
                        new Photo("LV003.jpg"),
                        new Photo("LV004.jpg"),
                        new Photo("LV005.jpg"),
                        new Photo("P001.jpg"),
                        new Photo("P002.jpg"),
                        new Photo("P003.jpg"),
                        new Photo("P004.jpg"),
                        new Photo("P005.jpg"),
                        new Photo("H001.jpg"),
                        new Photo("H002.jpg"),
                        new Photo("H003.jpg"),
                        new Photo("H004.jpg"),
                        new Photo("H005.jpg"),
                        new Photo("C001.jpg"),
                        new Photo("C002.jpg"),
                        new Photo("C003.jpg"),
                        new Photo("C004.jpg"),
                        new Photo("C005.jpg"),
                        new Photo("CP001.jpg"),
                        new Photo("CP002.jpg"),
                        new Photo("CP003.jpg"),
                        new Photo("CP004.jpg"),
                        new Photo("CP005.jpg")


                )
        );
        photoRepository.save(photos);
        log.info("Fotos cargadas en DataBase: " + photos.size());
    }
}
