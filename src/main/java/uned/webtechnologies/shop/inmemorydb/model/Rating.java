package uned.webtechnologies.shop.inmemorydb.model;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import java.util.Objects;

@Entity
 public class Rating {
    @EmbeddedId
    private ProductUserRating productUserRating;
    @OneToOne
    private RatingValue ratingValue;


    public Rating (){
        this.productUserRating=new ProductUserRating();

    }
    public Rating (ProductUserRating productUserRating){
        this.productUserRating=productUserRating;
    }

    public ProductUserRating getProductUserRating() {
        return productUserRating;
    }

    public void setProductUserRating(ProductUserRating productUserRating) {
        this.productUserRating = productUserRating;
    }

    public long getProductId(){
        return productUserRating.getProductId();
    }
    public void setProductId(long productId){
        productUserRating.setProductId(productId);
    }
    public long getUserId(){
        return productUserRating.getUserId();
    }
    public void setUserId(long user){
        productUserRating.setUserId(user);
    }
    public RatingValue getRatingValue(){
        return ratingValue;
    }
    public void setRatingValue(RatingValue ratingValue){
       this.ratingValue=ratingValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rating)) return false;
        Rating rating = (Rating) o;
        return getProductUserRating().equals(rating.getProductUserRating());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductUserRating());
    }

    @Override
    public String toString() {
        return "Rating{" +
                "productUserRating=" + productUserRating +
                ", value=" +
                '}';
    }
}



