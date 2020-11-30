package com.ddavydov.hardwareorders.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer extends BaseEntity {

    @Builder
    public Customer(UUID id, Timestamp createdDate, Timestamp lastModifiedDate, String customerName,
                    UUID apiKey, Set<HardwareOrder> hardwareOrders) {
        super(id, createdDate, lastModifiedDate);
        this.customerName = customerName;
        this.apiKey = apiKey;
        this.hardwareOrders = hardwareOrders;
    }

    private String customerName;

    @Column(length = 36, columnDefinition = "varchar")
    private UUID apiKey;

    @OneToMany(mappedBy = "customer")
    private Set<HardwareOrder> hardwareOrders;

}
