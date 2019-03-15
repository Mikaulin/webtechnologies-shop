package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Entity
public class Carrito {

    @Id
    @GeneratedValue
    private int id;
    private User user;
    private List<LineaProducto> lineas;

    public Carrito() {
    }

    public Carrito(User user) {
        this.user = user;
        lineas = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addLinea(LineaProducto linea) {
        this.lineas.add(linea);


    }

    public void removeLinea(LineaProducto linea) {
        this.lineas.remove(linea);

    }

    public void vaciarCarrito() {
        this.lineas.clear();
    }

    public double getTotal() {
        double total = 0;
        LineaProducto aux;
        for (LineaProducto linea : lineas) {
            aux = linea;
            total = aux.getCant() * aux.getProduct().getPriceDesc();


        }
        return total;
    }

    public List<LineaProducto> getLineas() {
        return lineas;


    }


}
