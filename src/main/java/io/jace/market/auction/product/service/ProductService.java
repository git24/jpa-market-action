package io.jace.market.auction.product.service;

import io.jace.market.auction.product.model.Product;
import io.jace.market.auction.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public UUID save(@Valid @NotNull Product product) {
        productRepository.save(product);
        return product.getId();
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
