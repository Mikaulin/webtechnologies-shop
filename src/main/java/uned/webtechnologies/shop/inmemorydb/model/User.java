package uned.webtechnologies.shop.inmemorydb.model;

import org.springframework.data.annotation.Transient;
import uned.webtechnologies.shop.utils.NumberUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

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

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        addRole(role);
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname1() {
        return lastname1;
    }

    public void setLastname1(String lastname1) {
        this.lastname1 = lastname1;
    }

    public String getLastname2() {
        return lastname2;
    }

    public void setLastname2(String lastname2) {
        this.lastname2 = lastname2;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    public Set<PurchaseLine> getPurchaseLines() {
        return purchaseLines;
    }

    public double getPruchaseTotalByDate(Calendar date) {
        Set<PurchaseLine> purchases = getPurchaseByDate(date);
        double total = 0;
        for (PurchaseLine p : purchases
        ) {
            total = total + p.getPurchasePrice();

        }
        return NumberUtils.roundDecimals(total);
    }

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

    public void setPurchaseLines(Set<PurchaseLine> purchaseLines) {
        this.purchaseLines = purchaseLines;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void addRole(Role role) {
        if (roles == null) {
            this.roles = new HashSet<>();
        }
        this.roles.add(role);
    }

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
                '}';
    }
}