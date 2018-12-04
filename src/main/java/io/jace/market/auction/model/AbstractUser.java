package io.jace.market.auction.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractUser extends BaseEntity {

    @Id
    @Column(name = "id")
    private UUID username;

    @NotBlank
    @Column(name = "cellphone", nullable = false)
    private String cellphone;

    protected AbstractUser() {
        username = UUID.randomUUID();
    }

    protected AbstractUser(@NotBlank String cellphone) {
        this();
        this.cellphone = cellphone;
    }

}
