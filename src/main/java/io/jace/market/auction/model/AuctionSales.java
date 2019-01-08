package io.jace.market.auction.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "auction_sales", schema = "auction")
public final class AuctionSales extends AbstractMarketSales {

    @NotNull
    @OneToMany(mappedBy = "auctionSales")
    private Set<Bidding> biddings;

    @Getter
    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Getter
    @Column(name = "closed_at")
    private LocalDateTime closedAt;

    protected AuctionSales() {
        super();
        this.biddings = new HashSet<>();
    }

    public AuctionSales(@Valid @NotNull Seller seller, @Valid @NotNull AbstractGoods goods) {
        super(seller, goods);
        this.biddings = new HashSet<>();
    }

    public void addBidding(Bidding bidding) {
        biddings.add(bidding);
    }

    public boolean startBidding() {
        if (startedAt != null) {
            return false;
        }
        startedAt = LocalDateTime.now();
        return true;
    }

    public boolean closeBidding() {
        if (closedAt != null) {
            return false;
        }
        closedAt = LocalDateTime.now();
        return true;
    }
}
