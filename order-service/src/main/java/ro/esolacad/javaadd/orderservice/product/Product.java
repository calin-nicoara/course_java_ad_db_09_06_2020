package ro.esolacad.javaadd.orderservice.product;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    private Long id;
    private String name;
    private Long stock;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

//    private Long categoryId;
}
