package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private Long id;
    private String foto;
    private String marca;
    private String descripcion;
    private Double priceOrg;
    private Double priceRbj;
    private Double ahorro;
    private int unidades;

    public Product(){

    }

    public Product(Long id, String foto, String marca, String descripcion, Double priceOrg, Double priceRbj, Double ahorro, int unidades) {
        this.id = id;
        this.foto = foto;
        this.marca = marca;
        this.descripcion = descripcion;
        this.priceOrg = priceOrg;
        this.priceRbj = priceRbj;
        this.ahorro = ahorro;
        this.unidades = unidades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPriceOrg() {
        return priceOrg;
    }

    public void setPriceOrg(Double priceOrg) {
        this.priceOrg = priceOrg;
    }

    public Double getPriceRbj() {
        return priceRbj;
    }

    public void setPriceRbj(Double priceRbj) {
        this.priceRbj = priceRbj;
    }

    public Double getAhorro() {
        return ahorro;
    }

    public void setAhorro(Double ahorro) {
        this.ahorro = ahorro;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", priceOrg=" + priceOrg +
                ", priceRbj=" + priceRbj +
                ", ahorro=" + ahorro +
                ", unidades=" + unidades +
                '}';
    }
}
