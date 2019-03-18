package uned.webtechnologies.shop.inmemorydb.model;

import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

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
    private String tlf;
    private int pc;
    private String password;

    @Transient
    private String passwordConfirm;

    private String username;
    private boolean subscribed;
    @OneToMany(mappedBy = "user")
    private Set<Cart> carts;
    @OneToMany (mappedBy = "user")
    private Set<PurchaseLine> purchaseLines;





    @ManyToMany
    private Set<Role> roles;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.passwordConfirm=password;

    }


    public long getId() {
        return id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" +
                '}';
    }
}
