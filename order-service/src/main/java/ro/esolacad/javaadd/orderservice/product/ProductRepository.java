package ro.esolacad.javaadd.orderservice.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findFirstByName(String name);

    @Query("SELECT p FROM Product p where p.price = :price and " +
            " p.status = 'INACTIVE'")
    List<Product> findByPriceAndIsInactive(@Param("price") BigDecimal price);
}
