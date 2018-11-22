package io.jace.market.auction.model;

public interface AuctionExecutor {

    void addBidding(Bidding bidding);

    boolean startBidding();
    boolean closeBidding();

}
