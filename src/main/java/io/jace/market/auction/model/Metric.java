package io.jace.market.auction.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "metric", schema = "metric")
public class Metric {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

}
