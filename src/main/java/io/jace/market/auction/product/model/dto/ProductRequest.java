package io.jace.market.auction.product.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public final class ProductRequest {
    @NotBlank
    private String name;
}
