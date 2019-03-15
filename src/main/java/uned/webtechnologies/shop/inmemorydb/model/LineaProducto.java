package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LineaProducto {

    @Id
    @GeneratedValue
    private int id;
    private Product product;
    private double cant;

    public LineaProducto() {
    }

    public LineaProducto(Product product) {
        this.product = product;
        this.cant = 1;

    }

    public LineaProducto(Product product, double cant) {
        this.product = product;
        this.cant = cant;

    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public boolean addProduct(Product product, int cant) {
        if (!this.product.equals((product))) return false;
        this.cant = this.cant + cant;


        return true;
    }

    public void removeProduct(int cant) {
        if (cant < this.cant) this.cant = 0;
        this.cant = this.cant - cant;


    }
    public double getPrecioCompra(){
        return this.cant*product.getPriceDesc();
    }


    @Override
    public String toString() {
        return "LineaProducto{" +
                "id=" + id +
                ", product=" + product +
                ", cant=" + cant +
                '}';
    }
}
