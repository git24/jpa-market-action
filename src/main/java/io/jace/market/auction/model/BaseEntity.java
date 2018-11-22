package io.jace.market.auction.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @Getter
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public BaseEntity() {
        createdAt = LocalDateTime.now();
    }
}
