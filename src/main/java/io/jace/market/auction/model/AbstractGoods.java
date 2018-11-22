package io.jace.market.auction.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractGoods extends BaseEntity implements CorrectGoodsValidator {

    @Getter
    @Id
    private final UUID id;

    public AbstractGoods() {
        super();
        this.id = UUID.randomUUID();
    }

}
