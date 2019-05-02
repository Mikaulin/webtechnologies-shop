package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Brand;
import uned.webtechnologies.shop.inmemorydb.repository.BrandRepository;

import java.util.List;

/** Servicio que implementa la lógica de negócio del MVC entre el controlador y las Marcas del modelo
 *
 */

@Service
public class BrandService {


    @Autowired
    private BrandRepository brandRepository;


    /**Método que devuelve las Marcas del repositorio
     * @return Las marcas del repositorio
     * @see Brand
     */
    public List<Brand> getBrands() {
        return this.brandRepository.findAll();
    }


}
