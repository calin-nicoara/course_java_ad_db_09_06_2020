package ro.esolacad.javaadd.orderservice.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void saveNewProduct(final ProductModel productModel) {
//        log.info("Product is saved!");
//        log.warn("Did not find product!");
//        log.error("Exception!");
//        log.error("asdas", new Exception());

        productModel.setStatus(ProductStatus.INACTIVE);
        productModel.setPrice(BigDecimal.ZERO);

        productRepository.save(ProductMapper.toProduct(productModel));
    }

    public List<ProductModel> findAllProducts(final int page, final int size) {
        return productRepository.findAll(PageRequest.of(page, size))
                .stream()
                .map(product -> ProductMapper.toProductModel(product))
                .collect(Collectors.toList());
    }

    public Optional<ProductModel> findById(Long id) {
        return productRepository.findById(id)
                .map(ProductMapper::toProductModel);
    }
}
