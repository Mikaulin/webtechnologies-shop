package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Category;
import uned.webtechnologies.shop.inmemorydb.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    /**
     * @see Category
     * @see CategoryRepository
     */

    @Autowired
    private CategoryRepository categoryRepository;

    /**Método que devuelve las categorías del repositorio
     * @return Lista de categorías del repositorio
     * @see CategoryRepository
     * @see Category
     */
    public List<Category> getCategories() {
        return this.categoryRepository.findAll();
    }
}
