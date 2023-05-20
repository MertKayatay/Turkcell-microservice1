package com.kodlamaio.rentalservice.api.clients;

import com.kodlamaio.commonpackage.utils.dto.ClientResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class CarClientFallback implements CarClient{
    @Override
    public ClientResponse checkIfCarAvailable(UUID carId) {
        log.info("CAR SERVICE IS DOWN");
        throw new RuntimeException("INVENTORY SERVICE IS DOWN");
    }
}
