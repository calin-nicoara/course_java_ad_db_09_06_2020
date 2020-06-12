package ro.esolacad.javaadd.orderservice.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testSaveProduct() {
        ProductModel inputProduct = ProductModel.builder()
                .id(1L)
                .name("Coca-Cola")
                .stock(10L)
                .price(BigDecimal.ONE)
                .status(ProductStatus.ACTIVE)
                .build();

        Product savedProduct = new Product(1L, "Coca-Cola", 10L, BigDecimal.ZERO, ProductStatus.INACTIVE);

        productService.saveNewProduct(inputProduct);

        Mockito.verify(productRepository, times(1)).save(savedProduct);

        Mockito.verifyNoMoreInteractions(productRepository);
    }

    @Test
    public void testGetAllProducts() {
        int page = 0;
        int size = 10;

        Pageable pageForProducts = PageRequest.of(page, size);
        List<Product> expectedProducts = Collections.singletonList(getProductForGetAllProducts());

        Mockito.when(productRepository.findAll(pageForProducts))
                .thenReturn(new PageImpl<>(expectedProducts));

        List<ProductModel> productPage = productService.findAllProducts(page, size);

        Mockito.verify(productRepository, times(1))
                .findAll(pageForProducts);

        assertIterableEquals(Collections.singletonList(getProductModelForGetAllProducts()),
                productPage);
    }

    private Product getProductForGetAllProducts() {
        return Product.builder()
                    .id(1L)
                    .name("Coca-Cola")
                    .stock(10L)
                    .price(BigDecimal.ONE)
                    .status(ProductStatus.ACTIVE)
                    .build();
    }

    private ProductModel getProductModelForGetAllProducts() {
        return ProductModel.builder()
                .id(1L)
                .name("Coca-Cola")
                .stock(10L)
                .price(BigDecimal.ONE)
                .status(ProductStatus.ACTIVE)
                .build();
    }

}
