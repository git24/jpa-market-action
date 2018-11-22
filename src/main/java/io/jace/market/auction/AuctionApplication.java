package io.jace.market.auction;

import io.jace.market.auction.model.UsedLaptop;
import io.jace.market.auction.repository.UsedLaptopRepository;
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
	public CommandLineRunner demo(UsedLaptopRepository usedLaptopRepository) {
		return (args) -> {
			usedLaptopRepository.save(new UsedLaptop("111-11", "apple", "mac book 2016"));
			usedLaptopRepository.save(new UsedLaptop("111-12", "apple", "mac book pro 2017"));
			usedLaptopRepository.save(new UsedLaptop("111-13", "apple", "mac book pro 2018"));
		};
	}
}
