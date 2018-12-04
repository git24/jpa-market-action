package io.jace.market.auction.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Entity
@Table(name = "bidder")
public final class Bidder extends AbstractUser {

    protected Bidder() {
        super();
    }

    public Bidder(
            @NotBlank String cellphone
    ) {
        super(cellphone);
    }

}
