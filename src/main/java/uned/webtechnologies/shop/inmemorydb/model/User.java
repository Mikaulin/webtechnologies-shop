package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private Long id;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String provincia;
    private String pais;
    private String email;
    private String tlf;
    private int cp;
    private String username;
    private String password;



    public User() {
    }

    public User(Long id, String nombre, String apellidos, String direccion, String provincia, String pais, String email, String tlf, int cp, String username, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.provincia = provincia;
        this.pais = pais;
        this.email = email;
        this.tlf = tlf;
        this.cp = cp;
        this.username = username;
        this.password = password;

    }

    public Long getId() {
        return id;
    }

    public String getUserNombre() {
        return nombre;
    }

    public String getUserApellidos() {
        return apellidos;
    }

    public String getUserDireccion() {
        return direccion;
    }

    public String getUserProvincia() {
        return provincia;
    }

    public String getUserPais() {
        return pais;
    }

    public String getUserEmail() {
        return email;
    }

    public String getUserTlf() {
        return tlf;
    }

    public int getUserCp() {
        return cp;
    }

    public String getUserName() {
        return username;
    }

    public String getUserPwd() {
        return password;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", provincia='" + provincia + '\'' +
                ", pais='" + pais + '\'' +
                ", email='" + email + '\'' +
                ", tlf='" + tlf + '\'' +
                ", cp=" + cp + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password +
                '}';
    }
}
