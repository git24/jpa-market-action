package io.jace.market.auction.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Entity
@Table(name = "bidder")
public final class Bidder extends BaseEntity {

    @Id
    @Column(name = "id")
    private String username;

    @NotBlank
    @Column(name = "cellphone", nullable = false)
    private String cellphone;

    protected Bidder() {
        super();
    }

    public Bidder(
            @NotBlank String username,
            @NotBlank String cellphone
    ) {
        this();
        this.username = username;
        this.cellphone = cellphone;
    }

}
