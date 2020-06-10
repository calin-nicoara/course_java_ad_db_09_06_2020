package ro.esolacad.javaad.lab;

public class Product {

    private String product;
    private int price;
    private boolean isOutOfStock;

    public Product(final String product, final int price, final boolean isOutOfStock) {
        this.product = product;
        this.price = price;
        this.isOutOfStock = isOutOfStock;
    }

    public Product() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(final String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(final int price) {
        this.price = price;
    }

    public boolean isOutOfStock() {
        return isOutOfStock;
    }

    public void setOutOfStock(final boolean outOfStock) {
        isOutOfStock = outOfStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product='" + product + '\'' +
                ", price=" + price +
                ", isOutOfStock=" + isOutOfStock +
                '}';
    }
}
