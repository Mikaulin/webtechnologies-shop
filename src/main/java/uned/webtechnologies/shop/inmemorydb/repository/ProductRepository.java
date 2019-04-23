package uned.webtechnologies.shop.inmemorydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uned.webtechnologies.shop.inmemorydb.model.Brand;
import uned.webtechnologies.shop.inmemorydb.model.Category;
import uned.webtechnologies.shop.inmemorydb.model.Product;

import java.util.List;

/**
 * Monta un repositorio de Productos en la BBDD
 * @see JpaRepository
 * @see Product
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
     /**Devuelve todos los productos que pertenecen a una categoría concreta
      * @param category Categoría sobre la que se hace la consulta
      * @return Lista de productos que pertenecen a la categoría.
      * @see Category
      */
     List<Product> getProductByCategory(Category category);

     /**Devuelve todos los productos que pertenecen a una marca concreta
      * @param brand Marca sobre la que se realiza la consulta
      * @return Lista de productos que pertenecen a la marca
      * @see Brand
      */
     List<Product> getProductByBrand(Brand brand);

     /**Devuelve todos los productos destacados
      * @return Lista de productos destacados
      */
     List<Product> getProductByFeaturedTrue();

     /**Devuelve todos los productos que pertenecen a una marca concreta
      * @param id Identificador único de la marca sobre la que se realiza la consulta
      * @return Lista de productos que pertenecen a la marca
      * @see Brand
      */
     List<Product> getProductByBrandId(long id);

     /**Devuelve todos los productos que pertenecen a una categoría concreta
      * @param id Identificador único de la categoria sobre la que se realiza la consulta
      * @return Lista de productos que pertenecen a la categoría
      * @see Category
      */
     List<Product> getProductByCategoryId(long id);




}