package io.jace.market.auction.repository;

import io.jace.market.auction.model.AuctionSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsedLaptopGoodsRepository extends JpaRepository<AuctionSales, UUID> {
}
