package com.ddavydov.hardwareorders.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface HardwareOrderLine extends PagingAndSortingRepository<HardwareOrderLine, UUID> {
}
