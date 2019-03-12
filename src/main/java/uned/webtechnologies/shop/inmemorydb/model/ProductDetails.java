package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.*;

@Entity
public class ProductDetails {
    @Id
    @GeneratedValue
    private int id;
    private int altura;
    private int anchura;
    private int fondo;

    public ProductDetails(){}

    public ProductDetails(int altura, int anchura, int fondo) {

        this.altura = altura;
        this.anchura = anchura;
        this.fondo = fondo;
    }



    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAnchura() {
        return anchura;
    }

    public void setAnchura(int anchura) {
        this.anchura = anchura;
    }

    public int getFondo() {
        return fondo;
    }

    public void setFondo(int fondo) {
        this.fondo = fondo;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "id=" + id +
                ", altura=" + altura +
                ", anchura=" + anchura +
                ", fondo=" + fondo +
                '}';
    }
}
