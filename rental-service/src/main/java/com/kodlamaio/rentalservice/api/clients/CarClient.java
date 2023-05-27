package com.kodlamaio.rentalservice.api.clients;

import com.kodlamaio.commonpackage.events.inventory.CarCreatedEvent;
import com.kodlamaio.commonpackage.utils.dto.ClientResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
@Retry(name = "inventory-retry")
@FeignClient(name = "inventory-service", fallback = CarClientFallback.class)
public interface CarClient {
    @GetMapping(value = "/api/cars/check-car-available/{carId}")
    ClientResponse checkIfCarAvailable(@PathVariable UUID carId);

    @GetMapping(value = "/api/cars/carinfo/{carId}")
    CarCreatedEvent getByIdForRental(@PathVariable UUID carId);
}