package ro.esolacad.javaad.day4.product;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductSearchEventListener {

    @EventListener
    public void handleProductSearched(ProductSearchEvent productSearchEvent) {
        System.out.println("Hello from ProductSearchEventListener: " +
                productSearchEvent.getMessage());
    }
}
