package uned.webtechnologies.shop.inmemorydb.model;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductoComprado {

    @Id
    @GeneratedValue
    private int id;
    private double count;
    private String name;
    private String photo;
    private double precioUnitario;
    private double precioCompra;
    private int idPadre;

    public ProductoComprado(){}

    public ProductoComprado(LineaProducto lineaProducto){
        this.count=lineaProducto.getCant();
        this.name=lineaProducto.getProduct().getName();
        this.photo=lineaProducto.getProduct().getPhoto();
        this.precioUnitario=lineaProducto.getProduct().getPriceDesc();
        this.precioCompra=precioUnitario*count;
        this.idPadre=lineaProducto.getProduct().getId();

    }







}
