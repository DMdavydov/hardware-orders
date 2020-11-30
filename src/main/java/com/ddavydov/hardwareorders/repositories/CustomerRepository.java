package com.ddavydov.hardwareorders.repositories;

import com.ddavydov.hardwareorders.domain.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, UUID> {
}
