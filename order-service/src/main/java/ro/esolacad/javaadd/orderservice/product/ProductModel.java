package ro.esolacad.javaadd.orderservice.product;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductModel {

    private Long id;
    private String name;
    private Long stock;
    private BigDecimal price;
    private ProductStatus status;
}
