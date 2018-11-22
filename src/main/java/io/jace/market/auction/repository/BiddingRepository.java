package io.jace.market.auction.repository;

import io.jace.market.auction.model.Bidding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BiddingRepository extends JpaRepository<Bidding, UUID> {
}
