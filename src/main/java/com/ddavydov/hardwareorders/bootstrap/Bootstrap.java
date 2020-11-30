package com.ddavydov.hardwareorders.bootstrap;

import com.ddavydov.hardwareorders.domain.Customer;
import com.ddavydov.hardwareorders.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {
    public static final String TESTING_ROOM = "Testing Room";

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadCustomerData();
    }

    private void loadCustomerData() {
        if (customerRepository.count() == 0) {
            customerRepository.save(Customer.builder()
                    .customerName(TESTING_ROOM)
                    .apiKey(UUID.randomUUID())
                    .build());
        }
    }
}
