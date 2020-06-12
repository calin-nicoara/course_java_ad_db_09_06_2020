package ro.esolacad.javaadd.orderservice.springex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import ro.esolacad.javaadd.orderservice.product.Product;
import ro.esolacad.javaadd.orderservice.old.ProductRepositoryOld;

@Configuration
public class ExampleBeanConfig {

//    @Bean
    @Primary
    public ProductRepositoryOld productRepository() {
        return new ProductRepositoryOld() {
            {
                System.out.println("ProductRepository only once!");
            }

            @Override
            public void save(final Product product) {
                System.out.println("Saved product!");
                System.out.println(product);
            }
        };
    }
}
