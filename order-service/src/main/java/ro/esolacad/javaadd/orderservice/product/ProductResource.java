package ro.esolacad.javaadd.orderservice.product;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductResource {

    private final ProductService productService;

    @GetMapping
    public List<ProductModel> findAllProducts(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size
    ) {
        return productService.findAllProducts(page, size);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductModel> findById(@PathVariable("productId") Long id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.ok()
                        .build());
    }

    @PostMapping
    public void saveProduct(@RequestBody ProductModel productModel) {
        productService.saveNewProduct(productModel);
    }
}
