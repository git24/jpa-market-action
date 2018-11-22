package io.jace.market.auction.product.model.dto;

import io.jace.market.auction.product.model.Product;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public final class ProductResponse {
    private UUID id;
    private String name;
    private Instant createdAt;

    public ProductResponse(Product product) {
        id = product.getId();
        name = product.getName();
        createdAt = product.getCreatedAt();
    }
}
