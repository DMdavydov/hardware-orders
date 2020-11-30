package com.ddavydov.hardwareorders.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by jt on 2019-01-26.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class HardwareOrderLine extends BaseEntity {

    @Builder
    public HardwareOrderLine(UUID id, Timestamp createdDate, Timestamp lastModifiedDate,
                         HardwareOrder hardwareOrder, UUID hardwareId, Integer orderQuantity,
                         Integer quantityAllocated) {
        super(id, createdDate, lastModifiedDate);
        this.hardwareOrder = hardwareOrder;
        this.hardwareId = hardwareId;
        this.orderQuantity = orderQuantity;
        this.quantityAllocated = quantityAllocated;
    }

    @ManyToOne
    private HardwareOrder hardwareOrder;

    private UUID hardwareId;
    private Integer orderQuantity = 0;
    private Integer quantityAllocated = 0;
}
