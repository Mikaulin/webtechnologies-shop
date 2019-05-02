package uned.webtechnologies.shop.inmemorydb.model;

import org.springframework.data.annotation.Transient;
import uned.webtechnologies.shop.utils.NumberUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Esta clase Método que define un Usuario
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

    /**
     * Construye un nuevo usuario con un nombre, apellido, dirección completa, número de telefono,dirección de correo electrónico, nombre de usuario , contraseña y Rol
     * @param name Nombre
     * @param lastname1 1er apellido
     * @param direction Dirección
     * @param city Ciudad
     * @param postalCode Codigo postal
     * @param province Provincia
     * @param country País
     * @param email Dirección de correo electrónico
     * @param phone Número de telefono
     * @param username Nombre de usuario
     * @param password Contraseña
     * @param role Role
     */
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
     * Método que devuelve el identificador único del usuario
     *
     * @return long con el identificador único del usuario
     */
    public long getId() {
        return id;
    }

    /**
     * Método que define el identificador único del usuario
     *
     * @param id Identificador único del usuario
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Método que devuelve el Nombre (real) del usuario
     *
     * @return Nombre (real) del usuario
     */
    public String getName() {
        return name;
    }

    /**
     * Método que define el nombre (real) del usuario
     *
     * @param name Nombre (real) del usuario
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método que devuelve el primer apellido del usuario
     *
     * @return Primer apellido del usuario
     */
    public String getLastname1() {
        return lastname1;
    }

    /**
     * Método que define el primer apellido del usuario
     *
     * @param lastname1 Primer apellido del usuario
     */
    public void setLastname1(String lastname1) {
        this.lastname1 = lastname1;
    }

    /**
     * Método que devuelve el segundo apellido del usuario
     *
     * @return Segundo apellido del usuario
     */
    public String getLastname2() {
        return lastname2;
    }

    /**
     * Método que define el segundo apellido del usuario
     *
     * @param lastname2 Segundo apellido del usuario
     */
    public void setLastname2(String lastname2) {
        this.lastname2 = lastname2;
    }

    /**
     * Método que devuelve la dirección del usuario
     *
     * @return Dirección del usuario
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Método que define la dirección del usuario
     *
     * @param direction Dirección del usuario
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Método que devuelve la ciudad del usuario
     *
     * @return Ciudad del usuario
     */
    public String getCity() {
        return city;
    }

    /**
     * Método que define la ciudad del usuario
     *
     * @param city Ciudad del usuario
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Método que devuelve la provincia del usuario
     *
     * @return Provincia del usuario
     */
    public String getProvince() {
        return province;
    }

    /**
     * Método que define la provincia del usuario
     *
     * @param province Provincia del usuario
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Método que devuelve el país del usuario
     *
     * @return País del usuario
     */
    public String getCountry() {
        return country;
    }

    /**
     * Método que define el país del usuario
     *
     * @param country País del usuario
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Método que devuelve la dirección de correo electrónico del usuario
     *
     * @return Dirección de correo electrónico del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método que define la dirección de correo electrónico del usuario
     *
     * @param email Dirección de correo electrónico del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método que devuelve el número de teléfono del usuario
     *
     * @return Número de teléfono del usuario
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Método que define el número de teléfono del usuario
     *
     * @param phone Número de teléfono del usuario
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Método que devuelve el código postal del usuario
     *
     * @return Código postal del usuario
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * Método que define el código postal del usuario
     *
     * @param postalCode Código postal del usuario
     */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Método que devuelve un valor booleano para comprobar si el usuario esta activo o no. Cuando un usuarió este dado de baja el valor deverá ser falso.
     *
     * @return Booleano con el valor de la suscripción.
     */
    public boolean isSubscribed() {
        return subscribed;
    }

    /**
     * Método que define al usuario como suscrito o no, en función de si esta dado de alta o no en el sistema
     *
     * @param subscribed Booleano con el estado (alta o baja) del usuario en el sistema.
     */
    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    /**
     * Método que devuelve un conjunto "Set" de las lineas de carrito del usuario.
     * Las lineas de carrito son las compras por finalizar del usuario.
     *
     * @return Conjunto "Set" de Carts del usuario.
     * @see Cart
     */
    public Set<Cart> getCarts() {
        return carts;
    }

    /**
     * Método que define un conjunto de lineas de compra sin finalizar del usuario
     *
     * @param carts Conjunto "Set" de compras por finalizar del usuario.
     * @see Cart
     */
    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }


    /**
     * Método que devuelve el coste total de las compras realizadas en una determinda fecha.
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
     * Método que devuelve las compras realizadas en una determinada fecha.
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
     * Método que define las compras realizadas
     *
     * @param purchaseLines Conjunto "Set" que contiene las compras realizadas
     * @see PurchaseLine
     */
    public void setPurchaseLines(Set<PurchaseLine> purchaseLines) {
        this.purchaseLines = purchaseLines;
    }


    /**
     * Método que devuelve el nombre del usuario
     *
     * @return Nombre del usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * Método que devuelve la contraseña del usuario
     *
     * @return Contraseña del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método que devuelve la confirmación de contraseña del usuario
     *
     * @return Clonfirmación de contraseña del usuario
     */
    public String getPasswordConfirm() {
        return passwordConfirm;
    }


    /**
     * Método que devuelve los roles asignados al usuario
     *
     * @return Conjunto "Set" de roles asignados al usuario
     * @see Role
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Método que define el identificador único del usuario
     *
     * @param id Identificador único del usuario
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método que define el nombre de usuario del usuario
     *
     * @param username Nombre de usuario del usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Método que define la contraseña del usuario
     *
     * @param password Contraseña del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Método que define la confirmación de contraseña del usuario
     *
     * @param passwordConfirm Confirmación de contraseña del usuario
     */
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    /**
     * Método que define los roles asignados al usuario
     *
     * @param roles Conjunto "Set" de roles asignados al usuario
     * @see Role
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /**Método que devuelve un booleano sobre el estado "borrado" del usuario
     * @return Booleano sobre el estado "borrado" del usuario
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**Método que define el estado "borrado" del usuario
     * @param deleted booleano del estado "borrado" del usuario.
     */
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

    /** Método que devuelve todas las compras realizadas
     * @return Conjunto "Set" de las compras realizadas.
     * @see PurchaseLine
     * @see Set
     */
    public Set<PurchaseLine> getPurchaseLines() {
        return purchaseLines;
    }


    /**
     * Método que devuelve una cadena que representa el Usuario
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
