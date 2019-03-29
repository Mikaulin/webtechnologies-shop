package uned.webtechnologies.shop.controllers.output;

public class AddToCartOutput {
    private String message;
    private int totalProducts;

    public int getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(int totalProducts) {
        this.totalProducts = totalProducts;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
