package io.jace.market.auction.model;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Entity
@Table(name = "bidding")
public final class Bidding extends BaseEntity {

    @Id
    @Column(name = "id")
    private final UUID id;

    @NotNull
    @Column(name = "amount", nullable = false)
    private Long amount;

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
            @NotNull Long amount,
            @Valid @NotNull Bidder bidder,
            @Valid @NotNull AuctionSales auctionSales
    ) {
        this();
        this.amount = amount;
        this.bidder = bidder;
        this.auctionSales = auctionSales;
    }

}
