package uned.webtechnologies.shop.controllers.input;

import javax.validation.constraints.NotNull;

public class RemoveCartInput {

    @NotNull(message = "El ID del producto no puede ser nulo.")
    private int productId;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


}
