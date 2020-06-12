package ro.esolacad.javaadd.orderservice.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServiceTestIT {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

//    @Test
//    public void testH2() {
//        Product inputProduct = new Product(1L, "Coca-Cola", 10L, BigDecimal.ONE, ProductStatus.ACTIVE);
//        Product savedProduct = new Product(1L, "Coca-Cola", 10L, BigDecimal.ZERO, ProductStatus.INACTIVE);
//
//        productService.saveNewProduct(inputProduct);
//
//        Optional<Product> byId = productRepository.findById(1L);
//
//        Assertions.assertTrue(byId.isPresent());
//
//        assertEquals(inputProduct, savedProduct);
//    }

    @Test
    public void testFindByName() {
        Product product1 = Product.builder()
                .id(1L)
                .name("Coca-Cola")
                .stock(10L)
                .price(BigDecimal.ONE)
                .status(ProductStatus.ACTIVE)
                .build();

        Product product2 = Product.builder()
                .id(2L)
                .name("Coca-Cola")
                .stock(20L)
                .price(BigDecimal.ONE)
                .status(ProductStatus.ACTIVE)
                .build();

        productRepository.save(product1);
        productRepository.save(product2);

//        List<Product> byName = productRepository.findByName("Coca-Cola");

//        assertEquals(2, byName.size());

        productRepository.findFirstByName("Coca-Cola");
    }

    @Test
    public void testDelete() {
        Product buildProduct = Product.builder()
                .id(1L)
                .name("Coca-Cola")
                .stock(10L)
                .price(BigDecimal.ONE)
                .status(ProductStatus.ACTIVE)
                .build();

        productRepository.save(buildProduct);

        productRepository.deleteById(1L);

        assertTrue(productRepository.findById(1L).isEmpty());
    }
}
