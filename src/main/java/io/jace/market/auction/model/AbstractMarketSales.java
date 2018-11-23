package io.jace.market.auction.model;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractMarketSales extends BaseEntity {

    @Id
    private final UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "goods_id")
    private AbstractGoods goods;

    protected AbstractMarketSales() {
        super();
        this.id = UUID.randomUUID();
    }

    public AbstractMarketSales(@Valid @NotNull Seller seller, @Valid @NotNull AbstractGoods goods) {
        this();
        this.seller = seller;
        this.goods = goods;
    }

}
