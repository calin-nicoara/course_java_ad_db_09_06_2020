package ro.esolacad.javaadd.orderservice.springex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ro.esolacad.javaadd.orderservice.product.Product;
import ro.esolacad.javaadd.orderservice.old.ProductRepositoryOld;

//@Configuration
public class ExampleBeanConfig2 {

    @Bean("productRepository2")
    public ProductRepositoryOld productRepository2() {
        return new ProductRepositoryOld() {
            {
                System.out.println("ProductRepository 2 only once!");
            }

            @Override
            public void save(final Product product) {
                System.out.println("Saved product from second!");
                System.out.println(product);
                System.out.println();
            }
        };
    }
}
