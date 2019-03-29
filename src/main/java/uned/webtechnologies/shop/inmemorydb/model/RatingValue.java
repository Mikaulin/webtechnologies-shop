package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class RatingValue implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private int value;
    public RatingValue(){}


    public RatingValue(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RatingValues{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
