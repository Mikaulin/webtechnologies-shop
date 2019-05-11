package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Photo {
    @Id
    @GeneratedValue
    private long id;

    private String url;

     public Photo(){}





    public Photo(String url){
         this.url=url;
     }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "url='" + url + '\'' +
                '}';
    }
}
