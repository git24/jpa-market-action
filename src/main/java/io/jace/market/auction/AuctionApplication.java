package io.jace.market.auction;

import io.jace.market.auction.model.*;
import io.jace.market.auction.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuctionApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(
			UsedLaptopRepository usedLaptopRepository,
			SellerRepository sellerRepository,
			BidderRepository bidderRepository,
			AuctionSalesRepository auctionSalesRepository,
			BiddingRepository biddingRepository
	) {
		return (args) -> {
			UsedLaptop usedLaptop1 = new UsedLaptop("111-11", "apple", "mac book 2016");
			UsedLaptop usedLaptop2 = new UsedLaptop("111-12", "apple", "mac book pro 2017");
			usedLaptopRepository.save(usedLaptop1);
			usedLaptopRepository.save(usedLaptop2);

			Seller seller = new Seller("Tester", "010-1111-2222");
			sellerRepository.save(seller);

			Bidder bidder1 = new Bidder("010-2222-3333");
			Bidder bidder2 = new Bidder("010-2222-4444");
			bidderRepository.save(bidder1);
			bidderRepository.save(bidder2);

			AuctionSales auctionSales1 = new AuctionSales(seller, usedLaptop1);
			AuctionSales auctionSales2 = new AuctionSales(seller, usedLaptop2);
			auctionSales1.startBidding();
			auctionSales2.startBidding();
			auctionSalesRepository.save(auctionSales1);
			auctionSalesRepository.save(auctionSales2);

			Bidding bidding1 = new Bidding(1000000L, bidder1, auctionSales1);
			Bidding bidding2 = new Bidding(1100000L, bidder2, auctionSales1);
			Bidding bidding3 = new Bidding(1300000L, bidder1, auctionSales2);
			biddingRepository.save(bidding1);
			biddingRepository.save(bidding2);
			biddingRepository.save(bidding3);

			auctionSales1.closeBidding();
			auctionSalesRepository.save(auctionSales1);
		};
	}
}
