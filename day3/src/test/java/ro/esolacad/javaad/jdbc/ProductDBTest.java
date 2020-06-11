package ro.esolacad.javaad.jdbc;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductDBTest {

//    @Test
    public void testFindAll() throws SQLException {
        ProductDB productDB = new ProductDB();

        List<Product> allProducts = productDB.findAllProducts();

        assert allProducts.size() == 3;

        assert allProducts.stream().anyMatch(product -> product.getId() == 10000L);
    }

//    @Test
    public void testSaveProduct() throws SQLException {
        ProductDB productDB = new ProductDB();

        Product product = new Product();
        product.setId(10005L);
        product.setName("Apa minerala");
        product.setPrice(BigDecimal.valueOf(2.5));
        product.setBrand("Dorna");

        productDB.saveProduct(product);
    }

    @Test
    public void testUpdateProduct() throws SQLException {
        ProductDB productDB =new ProductDB();

        Product product = new Product();
        product.setId(10005L);
        product.setName("Apa minerala");
        product.setPrice(BigDecimal.valueOf(3));
        product.setBrand("Borsec");

        productDB.updateProduct(product);
    }

}
