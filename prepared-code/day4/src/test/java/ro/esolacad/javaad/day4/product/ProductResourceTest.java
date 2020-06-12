package ro.esolacad.javaad.day4.product;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;

class ProductResourceTest {

    ProductResource productResourceTest = new ProductResource(
            new ProductConfigurations("test", true),
            Mockito.mock(ApplicationEventPublisher.class)
    );

    @Test
    public void testRest() {
        productResourceTest.findProduct();
    }
}
