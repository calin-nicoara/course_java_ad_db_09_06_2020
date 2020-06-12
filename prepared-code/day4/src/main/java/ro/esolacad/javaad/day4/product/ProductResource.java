package ro.esolacad.javaad.day4.product;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductResource {

    private final ProductConfigurations productConfigurations;
    private final ApplicationEventPublisher applicationEventPublisher;

    @GetMapping
    public ResponseEntity<?> findProduct() {

        ProductSearchEvent productSearchEvent = new ProductSearchEvent(this, "Hello!");
        applicationEventPublisher.publishEvent(productSearchEvent);
        return ResponseEntity.ok(productConfigurations.getExternalService());
    }
}
