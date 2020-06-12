package ro.esolacad.javaadd.orderservice.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AuxTests {

    @Test
    public void testGetterProduct() {
        Product inputProduct = new Product(1L, "Pepsi", 10L, BigDecimal.ONE, ProductStatus.ACTIVE);

        Assertions.assertEquals(inputProduct.getId(), 1L);
    }

    @Test
    public void testBuilderProduct() {
        Product inputProduct = new Product(1L, "Coca-Cola", 10L, BigDecimal.ONE, ProductStatus.ACTIVE);

        Product buildProduct = Product.builder()
                .id(1L)
                .name("Coca-Cola")
                .stock(10L)
                .price(BigDecimal.ONE)
                .status(ProductStatus.ACTIVE)
                .build();

        Assertions.assertEquals(buildProduct, inputProduct);

    }

}
