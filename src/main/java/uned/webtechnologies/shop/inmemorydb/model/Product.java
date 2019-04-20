package uned.webtechnologies.shop.inmemorydb.model;

import uned.webtechnologies.shop.utils.NumberUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Esta clase define un Producto.
 * La clase Producto pretende cubrir los atributos generales que se pueden esperar de cualquier tipo de producto que se quiera vender en una tienda de electrodomesticos.
 */

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private int count;
    private String name;
    private String description;
    private String photo;
    private double price;
    private double height;
    private double width;
    private double depth;
    private boolean featured;
    private boolean deleted;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_BRAND")
    private Brand brand;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CATEGORY")
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Promotion> promotions;

    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "productId")
    private List<Rating> ratingList;

    @Transient
    private double averageRating;

    @Transient
    private double ratingPercent;

    /**
     * <P>Metodo privado que se ejecuta tras persistir el objeto en la BBDD.</P>
     * <p>Calcula el rating del producto a partir de su lista de Rating, el pocentaje de rating y el promedio</p>
     *
     *
     * @see Rating
     */
    @PostLoad
    private void postLoad() {
        Integer sum = 0;
        if (!ratingList.isEmpty()) {
            for (Rating rating : ratingList) {
                sum += rating.getRatingValue().getValue();
            }
            this.averageRating = sum.doubleValue() / ratingList.size();
        } else {
            this.averageRating = 0;
        }
        //TODO Las constantes se deberían sacar a algún archivo de constanets
        this.ratingPercent = this.averageRating / 5 * 100;
    }

    public Product() {
        promotions = new HashSet<>();
    }

    /**
     * Define el identificador único del Producto
     *
     * @param id identificador único del producto
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Devuelve un conjunto "Set" con las promociones asignadas al producto
     *
     * @return Conjunto "Set" de promociones que tiene asignadas el producto-
     * @see Promotion
     */
    public Set<Promotion> getPromotions() {
        return promotions;
    }

    /**
     * Define las promociones que se le pueden aplicar al producto.
     *
     * @param promotions Conjunto "Set" de promociones aplicables al producto
     * @see Promotion
     */
    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }

    /**
     * Este constructor esta pensado para persistir los objetos en la bbdd al arrancar la aplicación.
     *
     * @param count       Numero de unidades disponibles
     * @param name        Nombre del producto
     * @param description Descripción del producto
     * @param photo       Foto del producto
     * @param price       Precio del producto
     * @param height      Altura del producto
     * @param width       Anchura del producto
     * @param depth       Profundidad del producto
     * @param deleted     Valor booleano que indica si el producto esta borrado
     * @param brand       Marca del producto
     * @param category    Categoría del producto
     * @param featured   Booleano que define el producto como destacado o no destacado
     * @see Brand
     * @see Category
     */
    public Product(int count, String name, String description, String photo, double price, double height, double width, double depth, boolean deleted, boolean featured, Brand brand, Category category) {
        promotions = new HashSet<>();
        this.count = count;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.price = price;

        this.height = height;
        this.width = width;
        this.depth = depth;
        this.deleted = deleted;
        this.brand = brand;
        this.category = category;
        this.featured = featured;
    }

    /**
     * Este constructor esta pensado para persistir los objetos en la bbdd al arrancar la aplicación.
     *
     * @param count       Numero de unidades disponibles
     * @param name        Nombre del producto
     * @param description Descripcion del producto
     * @param photo       foto del producto
     * @param price       Precio del producto
     * @param height      Altura del producto
     * @param width       Anchura del producto
     * @param depth       Profundidad del producto
     * @param featured    Valor booleano que indica si es un producto destacado
     * @param brand       Marca del producto
     * @param category    Categoria de producto
     */
    public Product(int count, String name, String description, String photo, double price, double height, double width, double depth, boolean featured, Brand brand, Category category) {
        promotions = new HashSet<>();
        this.count = count;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.price = price;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.brand = brand;
        this.category = category;
        this.featured = featured;
        this.deleted = false;
    }


    /**
     * Devuelve el identificador único del producto
     *
     * @return identificador único long del producto
     */
    public long getId() {
        return id;
    }


    /**
     * Asigna un conjunto "Set" de promociones al producto
     *
     * @param promo Conjunto "Set" de promociones que se le asignan al producto
     * @see Promotion
     */
    public void setPromotion(Promotion promo) {
        if (promotions == null) {
            Set<Promotion> promos = new HashSet<Promotion>();
            promos.add(promo);

            setPromotions(promos);
        } else {
            this.promotions.add(promo);
        }
    }

    /**
     * Devuelve la cantidad de productos disponibles
     *
     * @return Entero con la cantidad de productos disponibles
     */
    public int getCount() {
        return count;
    }

    /**
     * Define la cantidad de productos disponibles
     *
     * @param count Entero  con la cantidad de productos dissponibles
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Devuelve el nombre del  producto
     *
     * @return Cadena de texto con el nombre del producto
     */
    public String getName() {
        return name;
    }

    /**
     * Define el nombre del producto
     *
     * @param name Cadena que describe el producto
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve una descripción del producto un poco más especifica que el nombre
     *
     * @return Cadena descriptiva del producto
     */
    public String getDescription() {
        return description;
    }

    /**
     * Devuelve el porcentaje de descuento que se aplica al precio del producto
     *
     * @return double que representa el porcentaje de descuento aplicable al producto
     */
    public double getDiscount() {
        double discount = 0;

        if (promotions != null) {
            Calendar today = new GregorianCalendar();
            today.setTime(new Date());
            for (Promotion promo : this.promotions) {
                if ((today.after(promo.getStartDate())) && (today.before(promo.getEndDate()))) {
                    if (promo.getDiscount() > discount) {
                        discount = promo.getDiscount();
                    }
                }
            }
        }
        return discount;
    }

    /**
     * Devuelve el precio final del producto redondeado una vez aplicado el descuento.
     *
     * @return double con el precio final del producto redondeado una vez aplicado el descuento
     */
    public double getFinalPrice() {

        return NumberUtils.roundDecimals(this.price - (price * (getDiscount() / 100)));
    }

    /**
     * Devuelve la diferencia entre el precio original del producto y el precio final una vez aplicados los desctuentos
     *
     * @return double con la diferencia entre el precio original del producto y el precio final una vez aplicados los desctuentos
     */
    public double getDif() {
        return this.price - getFinalPrice();
    }

    /**
     * Define una descripcion del producto.
     *
     * @param description descripción del producto
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Devuelve la ruta a la foto del producto
     *
     * @return Cadena que contiene la ruta del producto
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Define la ruta a la foto del producto
     *
     * @param photo Cadena con la ruta a la foto del producto
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * Devuelve el precio sin descuento del producto
     *
     * @return double con el precio del producto sin descuento
     */
    public double getPrice() {
        return price;
    }

    /**
     * Define el precio del producto sin descuento
     *
     * @param price precio del producto sin descuento
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Devuelve un double con la altura del producto
     *
     * @return double con la altura del producto
     */
    public double getHeight() {
        return height;
    }

    /**
     * Define la altura del producto
     *
     * @param height Altura del producto
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Devuelve la anchura del producto
     *
     * @return double con la anchura del producto
     */
    public double getWidth() {
        return width;
    }

    /**
     * Define la anchura del producto
     *
     * @param width Anchura del producto
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Devuelve la profundidad del producto
     *
     * @return double con la profundidad del producto
     */
    public double getDepth() {
        return depth;
    }

    /**
     * Define la profundidad del producto
     *
     * @param depth la profundidad del producto
     */
    public void setDepth(double depth) {
        this.depth = depth;
    }

    /**
     * Devuelve un valor booleano verdadero si el producto esta borrado.
     * Sirve para descatalogar un producto sin tener que borrarlo de la base de datos
     *
     * @return booleano para comprobar si el producto esta borrado.
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * Define el estado "borrado-no borrado" del producto
     *
     * @param deleted booleano para definir si el producto esta o no borrado
     */
    public void setDeleted(boolean deleted) {

        this.deleted = deleted;
    }

    /**
     * Devuelve un objeto tipo  Marca del producto
     *
     * @return La marca del producto
     * @see Brand
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * Define la marca del producto
     *
     * @param brand Marca del producto.
     * @see Brand
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * Devuelve el objeto Categoria del producto
     *
     * @return Objeto Categoria del producto
     * @see Category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Define el objeto Categoria del producto
     *
     * @param category Objeto que define la categoria a la que pertenece el producto
     * @see Category
     */

    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Devuelve un booleano en funcion de si el producto es desatcado
     *
     * @return booleano con el valor del estado destacado del producto
     */
    public boolean isFeatured() {
        return featured;
    }


    /**
     * Define si el producto es destacado
     *
     * @param featured booleano para definir el producto como destacado o no destacado
     */
    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    /**
     * Devuelve una lista de Rating del producto
     *
     * @return Lista de Rating del producto
     * @see Rating
     */
    public List<Rating> getRatingList() {
        return ratingList;
    }


    /**
     * Define la lista de Rating del producto
     *
     * @param ratingList Lista con Rating del producto
     * @see Rating
     */
    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }


    /**
     * Devuelve el promedio de rating del producto
     *
     * @return double con el promedio de rating del producto
     */
    @Transient
    public double getAverageRating() {
        return averageRating;
    }

    /**
     * Devuelve el porcentaje de rating del producto
     *
     * @return double con el porcentaje del producto
     */
    @Transient
    public double getRatingPercent() {
        return ratingPercent;
    }

    /**
     * Devuelve una cadena de texto que representa el producto
     *
     * @return Cadena de texto que representa el producto
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", count=" + count +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                ", price=" + price +
                ", height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                ", featured=" + featured +
                ", deleted=" + deleted +
                ", brand=" + brand.getName() +
                ", category=" + category.getName() +
                ", rating=" +
                '}';
    }
}
