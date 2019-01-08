package io.jace.market.auction.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Entity
@Table(name = "used_laptop", schema = "auction")
public final class UsedLaptop extends AbstractGoods {

    @Id
    @Column(name = "id")
    private final UUID id;

    @NotBlank
    @Column(name = "serial_no", nullable = false)
    private String serialNo;

    @NotBlank
    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @NotBlank
    @Column(name = "model", nullable = false)
    private String model;

    protected UsedLaptop() {
        super();
        this.id = UUID.randomUUID();
    }

    public UsedLaptop(
            @NotBlank String serialNo,
            @NotBlank String manufacturer,
            @NotBlank String model
    ) {
        this();
        this.serialNo = serialNo;
        this.manufacturer = manufacturer;
        this.model = model;
    }

}
