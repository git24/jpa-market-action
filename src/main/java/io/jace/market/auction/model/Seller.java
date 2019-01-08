package io.jace.market.auction.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Entity
@Table(name = "seller", schema = "auction")
public final class Seller extends AbstractUser {

    @NotBlank(message = "nickname must not be blank")
    @Column(name = "nickname", nullable = false)
    private String nickname;

    protected Seller() {
        super();
    }

    public Seller(
            @NotBlank String nickname,
            @NotBlank String cellphone
    ) {
        super(cellphone);
        this.nickname = nickname;
    }

}
