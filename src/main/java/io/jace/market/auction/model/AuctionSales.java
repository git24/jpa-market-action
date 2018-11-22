package io.jace.market.auction.model;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "auction_sales")
public final class AuctionSales extends AbstractMarketSales implements AuctionExecutor {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "goods_id")
    private AbstractGoods goods;

    @NotNull
    @OneToMany(mappedBy = "auctionSales")
    private Set<Bidding> biddings;

    @Getter
    @Column(name = "started_at")
    private Instant startedAt;

    @Getter
    @Column(name = "closed_at")
    private Instant closedAt;

    public AuctionSales() {
        super();
        this.biddings = new HashSet<>();
    }

    public AuctionSales(Seller seller, AbstractGoods goods) {
        this();
        this.seller = seller;
        this.goods = goods;
    }

    @Override
    public Seller getSeller() {
        return this.seller;
    }

    @Override
    public AbstractGoods getGoods() {
        return this.goods;
    }

    @Override
    public void addBidding(Bidding bidding) {
        biddings.add(bidding);
    }

    @Override
    public boolean startBidding() {
        if (startedAt == null) {
            return false;
        }
        startedAt = Instant.now();
        return true;
    }

    @Override
    public boolean closeBidding() {
        if (closedAt == null) {
            return false;
        }
        closedAt = Instant.now();
        return true;
    }
}
