package io.jace.market.auction.product.controller;

import io.jace.market.auction.product.model.Product;
import io.jace.market.auction.product.model.dto.ProductRequest;
import io.jace.market.auction.product.model.dto.ProductResponse;
import io.jace.market.auction.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(productService.findAll().stream()
        .map(ProductResponse::new)
        .collect(Collectors.toList()));
    }

    @PostMapping("/products")
    public ResponseEntity<UUID> createProduct(
            @RequestBody @Valid ProductRequest productRequest
    ) {
        UUID id = productService.save(new Product(productRequest.getName()));
        return ResponseEntity.ok(id);
    }

}
