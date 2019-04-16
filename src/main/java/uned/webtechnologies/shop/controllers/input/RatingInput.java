package uned.webtechnologies.shop.controllers.input;

import javax.validation.constraints.NotNull;

public class RatingInput {

    @NotNull(message = "El ID del producto no puede ser nulo.")
    private int productId;

    @NotNull(message = "El rating no puede ser nulo.")
    private int count;

    public int getProductId() {
        return productId;
    }

    public int getCount() {
        return count;
    }



    public void setCount(int count) {
        this.count = count;
    }
}
