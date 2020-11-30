package com.ddavydov.hardwareorders.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

/**
 * Created by jt on 2019-01-26.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
public class HardwareOrder extends BaseEntity {

    @Builder
    public HardwareOrder(UUID id, Timestamp createdDate, Timestamp lastModifiedDate, String customerRef, Customer customer,
                     Set<HardwareOrderLine> hardwareOrderLines, OrderStatusEnum orderStatus,
                     String orderStatusCallbackUrl) {
        super(id, createdDate, lastModifiedDate);
        this.customerRef = customerRef;
        this.customer = customer;
        this.hardwareOrderLines = hardwareOrderLines;
        this.orderStatus = orderStatus;
        this.orderStatusCallbackUrl = orderStatusCallbackUrl;
    }

    private String customerRef;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "hardwareOrder", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private Set<HardwareOrderLine> hardwareOrderLines;

    private OrderStatusEnum orderStatus = OrderStatusEnum.NEW;
    private String orderStatusCallbackUrl;
}
