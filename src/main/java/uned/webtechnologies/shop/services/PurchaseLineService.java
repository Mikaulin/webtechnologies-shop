package uned.webtechnologies.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uned.webtechnologies.shop.inmemorydb.model.Cart;
import uned.webtechnologies.shop.inmemorydb.model.Product;
import uned.webtechnologies.shop.inmemorydb.model.PurchaseLine;
import uned.webtechnologies.shop.inmemorydb.model.User;
import uned.webtechnologies.shop.inmemorydb.repository.PurchaseLineRepository;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Servicio que implementa la lógica de negócio del MVC entre el controlador y las Lineas de compra del modelo
 *
 * @see PurchaseLineRepository
 * @see PurchaseLine
 */
@Service
public class PurchaseLineService {

    @Autowired
    private PurchaseLineRepository purchaseLineRepository;
    @Autowired
    private CartService cartService;


    /**
     *
     */
    public PurchaseLineService() {
    }

    /**
     * Método que devuelve las compras de una determinada fecha del repositorio
     *
     * @param date Calendar que contiene la fecha sobre la que se desean la compras
     * @return Lista de compras según fecha("PurchaseLine") del repositorio
     * @see PurchaseLineRepository
     * @see PurchaseLine
     */
    public List<PurchaseLine> getPurchasesByDate(Calendar date) {
        return this.purchaseLineRepository.findAllByDate(date);
    }

    /**
     * Método que devuelve una linea de compra del repositorio
     *
     * @param id Identificador único de la linea de compra
     * @return Compra ("PurchaseLine") del repositorio
     * @see PurchaseLineRepository
     * @see PurchaseLine
     */
    public PurchaseLine getOne(long id) {
        return this.purchaseLineRepository.findOne(id);
    }

    /**
     * Método que devuelve todas las compras del repositorio
     *
     * @return Lista de compras ("PurchaseLine") del repositorio.
     * @see PurchaseLineRepository
     * @see PurchaseLine
     */
    public List<PurchaseLine> getAllPurchases() {
        return this.purchaseLineRepository.findAll();
    }


    /**
     * Método empleado para guardar compras de ejemplo (Con fecha aleatoria) en el reppositorio
     *
     * @param purchaseLine Compra ("PurchaseLine") que ya tiene una fecha establecida a modo de ejemplo
     * @see PurchaseLineRepository
     * @see PurchaseLine
     */
    public void saveRandom(PurchaseLine purchaseLine) {
        purchaseLineRepository.save(purchaseLine);
    }


    /**
     * Método pensado para ser llamado antes de guardar una linea de compra.
     * Este metodo comprueba si hay unidades suficientes del producto que se desea comprar
     *
     * @param product Producto que se desea comprar
     * @param count   Cantidad de productos que se desean comprar
     * @throws RuntimeException Excepción lanzada en caso de no haber suficientes unidades del producto para realizar la compra
     */
    private void checkQuantity(Product product, int count) throws RuntimeException {

        if (product.getCount() < count)
            throw new RuntimeException("No hay suficientes unidades del producto : " + product.getName() + "\n" +
                    "Unidades solicitadas =" + count + "\n" +
                    "Unidades disponibles = " + product.getCount());
    }


    /**
     * Método transaccional, que se encarga de guardar una Linea de compra ("PurchaseLine") realizando las siguientes acciones:
     * <ul>
     * <li>Comprueba si hay cantidades suficientes en el repositorio</li>
     * <li>Define la fecha de la compra con la fecha actual</li>
     * <li>Si hay unidades suficientes guarda la compra en el repositorio</li>
     * </ul>
     *
     * @param purchaseLine Linea de compra que se desea comprobar y guardar
     * @see PurchaseLineRepository
     * @see PurchaseLine
     */
    @Transactional
    public void save(PurchaseLine purchaseLine) {
        Product product = purchaseLine.getProduct();
        int count = purchaseLine.getCount();
        int productCount = product.getCount();

        checkQuantity(product, count);
        Calendar today = new GregorianCalendar();
        today.getTime();
        purchaseLine.setDate(today);
        product.setCount(productCount - count);
        purchaseLineRepository.save(purchaseLine);

    }

    /**
     * Método que se encarga de realizar la devolución de una compra.
     * <ul>
     * <li>Añade la cantidad de productos de la compra al repositorio de productos</li>
     * <li>Borra la compra del repositorio de compras</li>
     * </ul>
     *
     * @param purchaseLine Linea de compra que se desea devolver
     * @see PurchaseLineRepository
     * @see PurchaseLine
     * @see uned.webtechnologies.shop.inmemorydb.repository.ProductRepository
     * @see Product
     */
    @Transactional
    public void returnPurchase(PurchaseLine purchaseLine) {
        Product product = purchaseLine.getProduct();
        int count = purchaseLine.getCount();
        int productCount = product.getCount();
        product.setCount(productCount + count);
        purchaseLineRepository.delete(purchaseLine);

    }

    /**
     * Metodo que se encarga de guardar una lista de Lineas de carrito (Cart) como compras en el repositorio de compras..
     *
     * @param carts Lista de lineas de carrito(Cart) que se desean comprar
     * @see PurchaseLineRepository
     * @see Cart
     */
    @Transactional
    public void saveCarts(List<Cart> carts) {
        PurchaseLine purchase;
        for (Cart cart : carts
        ) {
            purchase = new PurchaseLine();
            purchase.setProduct(cart.getProduct());
            purchase.setUnitPrice(cart.getUnitPrice());
            purchase.setCount(cart.getCount());
            purchase.setPurchasePrice(cart.getCartPrice());
            purchase.setUser(cart.getUser());
            this.save(purchase);
            this.cartService.removeCart(cart);


        }

    }

    /**
     * Método que devuelve la cantidad de compras existentes en el repositorio
     *
     * @return Número con la cantidad de compras existentes en el repositorio.
     * @see PurchaseLineRepository
     * @see PurchaseLine
     */
    public long count() {
        return this.purchaseLineRepository.count();
    }

    /**
     * Método que devuelve todas las compras del repositorio realizadas por un usuario concreto
     *
     * @param user Usuario del que se desean obtener las compras realizadas
     * @return Lista de Lineas de compra del usuario
     * @see PurchaseLineRepository
     * @see PurchaseLine
     * @see User
     */
    public List<PurchaseLine> getPurchaseLines(User user) {
        return this.purchaseLineRepository.findByUser(user);
    }


}
