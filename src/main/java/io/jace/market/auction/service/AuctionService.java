package io.jace.market.auction.service;

import io.jace.market.auction.repository.UsedLaptopRepository;
import org.springframework.stereotype.Service;

@Service
public class AuctionService {
    private final UsedLaptopRepository usedLaptopRepository;

    public AuctionService(UsedLaptopRepository usedLaptopRepository) {
        this.usedLaptopRepository = usedLaptopRepository;
    }

}
