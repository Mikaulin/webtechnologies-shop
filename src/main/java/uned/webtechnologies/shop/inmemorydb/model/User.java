package uned.webtechnologies.shop.inmemorydb.model;

import org.springframework.data.annotation.Transient;
import uned.webtechnologies.shop.utils.NumberUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Esta clase define un Usuario
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String lastname1;
    private String lastname2;
    private String direction;
    private String city;
    private String province;
    private String country;
    private String email;
    private String phone;
    private int postalCode;
    private String password;

    @Transient
    private String passwordConfirm;

    private String username;
    private boolean subscribed;
    @OneToMany(mappedBy = "user")
    private Set<Cart> carts;
    @OneToMany(mappedBy = "user")
    private Set<PurchaseLine> purchaseLines;
    @ManyToMany
    private Set<Role> roles;

    private boolean deleted = false;

    public User() {
    }

    /**
     * Construye un nuevo usuario con un nombre de usuario y una contraseña.
     *
     * @param username Nombre de usuario
     * @param password Contraseña de usuario
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Construye un nuevo usuario con un nombre de usuario, una contraseña y un role asignado.
     *
     * @param username Nombre de usuario
     * @param password Contraseña de usuario
     * @param role     Role de usuario
     */
    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        addRole(role);
    }

    /**
     * Construye un nuevo usuario con un nombre, apellido, dirección completa, número de telefono,dirección de correo electrónico, nombre de usuario y contraseña.
     *
     * @param name       Nombre
     * @param lastname1  1er apellido
     * @param direction  Dirección
     * @param city       Ciudad
     * @param postalCode Codigo Postal
     * @param province   Provincia
     * @param country    País
     * @param email      Dirección de correo electrónico
     * @param phone      Número de telefono
     * @param username   Nombre de usuario
     * @param password   Contraseña
     */
    public User(String name, String lastname1, String direction, String city, int postalCode, String province, String country, String email, String phone, String username, String password) {
        this.name = name;
        this.lastname1 = lastname1;
        this.direction = direction;
        this.city = city;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.passwordConfirm = password;
    }

    public User(String name, String lastname1, String direction, String city, int postalCode, String province, String country, String email, String phone, String username, String password, Role role) {
        this.name = name;
        this.lastname1 = lastname1;
        this.direction = direction;
        this.city = city;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.passwordConfirm = password;
        addRole(role);
    }

    /**
     * Devuelve el identificador único del usuario
     *
     * @return long con el identificador único del usuario
     */
    public long getId() {
        return id;
    }

    /**
     * Define el identificador único del usuario
     *
     * @param id Identificador único del usuario
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Devuelve el Nombre (real) del usuario
     *
     * @return Nombre (real) del usuario
     */
    public String getName() {
        return name;
    }

    /**
     * Define el nombre (real) del usuario
     *
     * @param name Nombre (real) del usuario
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve el primer apellido del usuario
     *
     * @return Primer apellido del usuario
     */
    public String getLastname1() {
        return lastname1;
    }

    /**
     * Define el primer apellido del usuario
     *
     * @param lastname1 Primer apellido del usuario
     */
    public void setLastname1(String lastname1) {
        this.lastname1 = lastname1;
    }

    /**
     * Devuelve el segundo apellido del usuario
     *
     * @return Segundo apellido del usuario
     */
    public String getLastname2() {
        return lastname2;
    }

    /**
     * Define el segundo apellido del usuario
     *
     * @param lastname2 Segundo apellido del usuario
     */
    public void setLastname2(String lastname2) {
        this.lastname2 = lastname2;
    }

    /**
     * Devuelve la dirección del usuario
     *
     * @return Dirección del usuario
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Define la dirección del usuario
     *
     * @param direction Dirección del usuario
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Devuelve la ciudad del usuario
     *
     * @return Ciudad del usuario
     */
    public String getCity() {
        return city;
    }

    /**
     * Define la ciudad del usuario
     *
     * @param city Ciudad del usuario
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Devuelve la provincia del usuario
     *
     * @return Provincia del usuario
     */
    public String getProvince() {
        return province;
    }

    /**
     * Define la provincia del usuario
     *
     * @param province Provincia del usuario
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Devuelve el país del usuario
     *
     * @return País del usuario
     */
    public String getCountry() {
        return country;
    }

    /**
     * Define el país del usuario
     *
     * @param country País del usuario
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Devuelve la dirección de correo electrónico del usuario
     *
     * @return Dirección de correo electrónico del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define la dirección de correo electrónico del usuario
     *
     * @param email Dirección de correo electrónico del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve el número de teléfono del usuario
     *
     * @return Número de teléfono del usuario
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Define el número de teléfono del usuario
     *
     * @param phone Número de teléfono del usuario
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Devuelve el código postal del usuario
     *
     * @return Código postal del usuario
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * Define el código postal del usuario
     *
     * @param postalCode Código postal del usuario
     */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Devuelve un valor booleano para comprobar si el usuario esta activo o no. Cuando un usuarió este dado de baja el valor deverá ser falso.
     *
     * @return Booleano con el valor de la suscripción.
     */
    public boolean isSubscribed() {
        return subscribed;
    }

    /**
     * Define al usuario como suscrito o no, en función de si esta dado de alta o no en el sistema
     *
     * @param subscribed Booleano con el estado (alta o baja) del usuario en el sistema.
     */
    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    /**
     * Devuelve un conjunto "Set" de las lineas de carrito del usuario.
     * Las lineas de carrito son las compras por finalizar del usuario.
     *
     * @return Conjunto "Set" de Carts del usuario.
     * @see Cart
     */
    public Set<Cart> getCarts() {
        return carts;
    }

    /**
     * Define un conjunto de lineas de compra sin finalizar del usuario
     *
     * @param carts Conjunto "Set" de compras por finalizar del usuario.
     * @see Cart
     */
    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }


    /**
     * Devuelve el coste total de las compras realizadas en una determinda fecha.
     *
     * @param date Calendar que contiene la fecha sobre la que se desean obtener el coste de las compras realizadas
     * @return double con el coste total de las compras realizadas según la fecha
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html">Calendar</a>
     */
    public double getPurchaseTotalByDate(Calendar date) {
        Set<PurchaseLine> purchases = getPurchaseByDate(date);
        double total = 0;
        for (PurchaseLine p : purchases
        ) {
            total = total + p.getPurchasePrice();

        }
        return NumberUtils.roundDecimals(total);
    }

    /**
     * Devuelve las compras realizadas en una determinada fecha.
     *
     * @param date Calendar que contiene la fecha sobre la que se desean obtener las compras realizadas
     * @return Conjunto "Set" con las compras realizadas según la fecha
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html">Calendar</a>
     * @see PurchaseLine
     */
    public Set<PurchaseLine> getPurchaseByDate(Calendar date) {
        Set<PurchaseLine> purchases = new HashSet<>();
        for (PurchaseLine p : this.purchaseLines
        ) {
            if (p.getDate().equals(date)) {
                purchases.add(p);
            }

        }

        return purchases;
    }

    /**
     * Define las compras realizadas
     *
     * @param purchaseLines Conjunto "Set" que contiene las compras realizadas
     * @see PurchaseLine
     */
    public void setPurchaseLines(Set<PurchaseLine> purchaseLines) {
        this.purchaseLines = purchaseLines;
    }


    /**
     * Devuelve el nombre del usuario
     *
     * @return Nombre del usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * Devuelve la contraseña del usuario
     *
     * @return Contraseña del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Devuelve la confirmación de contraseña del usuario
     *
     * @return Clonfirmación de contraseña del usuario
     */
    public String getPasswordConfirm() {
        return passwordConfirm;
    }


    /**
     * Devuelve los roles asignados al usuario
     *
     * @return Conjunto "Set" de roles asignados al usuario
     * @see Role
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Define el identificador único del usuario
     *
     * @param id Identificador único del usuario
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Define el nombre de usuario del usuario
     *
     * @param username Nombre de usuario del usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Define la contraseña del usuario
     *
     * @param password Contraseña del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Define la confirmación de contraseña del usuario
     *
     * @param passwordConfirm Confirmación de contraseña del usuario
     */
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    /**
     * Define los roles asignados al usuario
     *
     * @param roles Conjunto "Set" de roles asignados al usuario
     * @see Role
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * Añade un nuevo Role al usuario
     *
     * @param role Role que se le quiere añadir al usuario
     * @see Role
     */
    public void addRole(Role role) {
        if (roles == null) {
            this.roles = new HashSet<>();
        }
        this.roles.add(role);
    }

    /** Devuelve todas las compras realizadas
     * @return Conjunto "Set" de las compras realizadas.
     * @see PurchaseLine
     * @see Set
     */
    public Set<PurchaseLine> getPurchaseLines() {
        return purchaseLines;
    }


    /**
     * Devuelve una cadena que representa el Usuario
     *
     * @return Cadena que representa el usuario
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname1='" + lastname1 + '\'' +
                ", lastname2='" + lastname2 + '\'' +
                ", direction='" + direction + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", postalCode=" + postalCode +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                ", username='" + username + '\'' +
                ", subscribed=" + subscribed +
                ", carts=" + carts +
                ", purchaseLines=" + purchaseLines +
                ", roles=" + roles +
                '}';
    }
}
