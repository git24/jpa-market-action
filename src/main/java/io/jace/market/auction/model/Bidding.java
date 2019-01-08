package io.jace.market.auction.model;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Getter
@Entity
@Table(name = "bidding", schema = "auction")
public final class Bidding extends BaseEntity {

    @Id
    @Column(name = "id")
    private final UUID id;

    @NotNull
    @Positive
    @Column(name = "price", nullable = false)
    private Long price;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "bidder_id")
    private Bidder bidder;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "auction_sales_id")
    private AuctionSales auctionSales;

    protected Bidding() {
        super();
        this.id = UUID.randomUUID();
    }

    public Bidding(
            @NotNull @Positive Long price,
            @Valid @NotNull Bidder bidder,
            @Valid @NotNull AuctionSales auctionSales
    ) {
        this();
        this.price = price;
        this.bidder = bidder;
        this.auctionSales = auctionSales;
    }

}
