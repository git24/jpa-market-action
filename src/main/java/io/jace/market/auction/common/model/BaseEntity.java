package io.jace.market.auction.common.model;

import java.time.Instant;

public abstract class BaseEntity {

    private Instant createdAt;

    public BaseEntity() {
        createdAt = Instant.now();
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
