package com.ddavydov.hardwareorders.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface HardwareOrder extends PagingAndSortingRepository<HardwareOrder, UUID> {
}
