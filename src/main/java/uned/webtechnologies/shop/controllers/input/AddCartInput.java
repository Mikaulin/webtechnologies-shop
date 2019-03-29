package uned.webtechnologies.shop.controllers.input;

import javax.validation.constraints.NotNull;

public class AddCartInput {

    @NotNull(message = "El ID del producto no puede ser nulo.")
    private int productId;

    @NotNull(message = "La cantidad no puede ser nula.")
    private int count;

    public int getProductId() {
        return productId;
    }

    public int getCount() {
        return count;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
