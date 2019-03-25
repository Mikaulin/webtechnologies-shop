package uned.webtechnologies.shop.inmemorydb.model;

import javax.persistence.Embeddable;

import java.io.Serializable;



@Embeddable
public class ProductUserRating implements Serializable {

    private long userId;

    private long productId;

    public ProductUserRating() {
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ProductUserRating{" +
                "userId=" + userId +
                ", productId=" + productId +
                '}';
    }
}
