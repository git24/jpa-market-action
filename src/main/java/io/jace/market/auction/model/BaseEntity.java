package io.jace.market.auction.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
public abstract class BaseEntity {

    @Getter
    @Column(name = "created_at")
    private Instant createdAt;

    public BaseEntity() {
        createdAt = Instant.now();
    }
}
