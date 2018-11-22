package io.jace.market.auction.product.model;

import io.jace.market.auction.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Id
    private UUID id;

    @NotBlank
    private String name;

    public Product(String name) {
        super();
        this.id = UUID.randomUUID();
        this.name = name;
    }

}
