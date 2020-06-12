package ro.esolacad.javaad.day4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import ro.esolacad.javaad.day4.product.ProductConfigurations;

@SpringBootApplication
@EnableConfigurationProperties(ProductConfigurations.class)
public class Day4Application {

    public static void main(String[] args) {
        SpringApplication.run(Day4Application.class, args);
    }

}
