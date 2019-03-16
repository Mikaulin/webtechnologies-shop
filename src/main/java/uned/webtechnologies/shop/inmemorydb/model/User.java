package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String lastname1;
    private String lastname2;
    private String direction;
    private String city;
    private String province;
    private String country;
    private String email;
    private String tlf;
    private int pc;
    private String password;
    private String username;
    private boolean subscribed;
    @OneToMany (mappedBy = "user")
    private Set<Cart> carts;
    @OneToMany (mappedBy = "user")
    private Set<PurchaseLine> purchaseLines;






    public User() {
    }


    public User(String name, String lastname1, String direction, String city, String country, String email, String tlf,int pc, String username, String password) {
        this.name = name;
        this.lastname1 = lastname1;
        this.direction = direction;
        this.city = city;
        this.country = country;
        this.email = email;
        this.tlf = tlf;
        this.password = password;
        this.username = username;
        this.pc=pc;
        subscribed=true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setPurchaseLines(Set<PurchaseLine> purchaseLines) {
        this.purchaseLines = purchaseLines;
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
                ", tlf='" + tlf + '\'' +
                ", pc=" + pc +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", subscribed=" + subscribed +
                ", carts=" + carts +
                ", purchaseLines=" + purchaseLines +

                '}';
    }
}
