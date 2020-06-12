package ro.esolacad.javaadd.orderservice.springex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import ro.esolacad.javaadd.orderservice.product.Product;
import ro.esolacad.javaadd.orderservice.old.ProductRepositoryOld;

//@Service
public class SecondProductService {

    @PostConstruct
    public void init() {
        System.out.println("PRODUCT SERVICE 2 ON");

        Product product = new Product();
        product.setId(1L);
        productRepositoryOld.save(product);
    }

    private final ProductRepositoryOld productRepositoryOld;

    @Autowired
    public SecondProductService(final @Qualifier("productRepository2") ProductRepositoryOld productRepositoryOld) {
        this.productRepositoryOld = productRepositoryOld;
    }
}
