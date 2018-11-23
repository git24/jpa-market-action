package io.jace.market.auction.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Entity
@Table(name = "seller")
public final class Seller extends BaseEntity {

    @Id
    @Column(name = "id")
    private String username;

    @NotBlank
    @Column(name = "nickname", nullable = false)
    private String nickname;

    @NotBlank
    @Column(name = "cellphone", nullable = false)
    private String cellphone;

    protected Seller() {
        super();
    }

    public Seller(
            @NotBlank String username,
            @NotBlank String nickname,
            @NotBlank String cellphone
    ) {
        this();
        this.username = username;
        this.nickname = nickname;
        this.cellphone = cellphone;
    }

}
