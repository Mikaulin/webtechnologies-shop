package uned.webtechnologies.shop.controllers.input;

import javax.validation.constraints.NotNull;

public class UpdateCartInput {

    @NotNull(message = "El ID del producto no puede ser nulo.")
    private int cartId;

    @NotNull(message = "La cantidad no puede ser nula.")
    private int count;

    public int getCartId() {
        return cartId;
    }

    public int getCount() {
        return count;
    }

    public void setCartIdId(int cartId) {
        this.cartId = cartId;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
