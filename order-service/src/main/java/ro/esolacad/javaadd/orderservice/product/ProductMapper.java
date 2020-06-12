package ro.esolacad.javaadd.orderservice.product;

public class ProductMapper {

    public static ProductModel toProductModel(Product product) {
        return ProductModel
                .builder()
                .id(product.getId())
                .name(product.getName())
                .stock(product.getStock())
                .price(product.getPrice())
                .status(product.getStatus())
                .build();
    }

    public static Product toProduct(ProductModel productModel) {
        return Product
                .builder()
                .id(productModel.getId())
                .name(productModel.getName())
                .stock(productModel.getStock())
                .price(productModel.getPrice())
                .status(productModel.getStatus())
                .build();
    }
}
