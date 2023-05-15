package com.kodlamaio.rentalservice.api.clients;

import com.kodlamaio.commonpackage.utils.dto.ClientResponse;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

@Slf4j
@Component
@EnableScheduling
public class CarClientFallback implements CarClient {

    //@Scheduled(fixedRate = 5000)
    @Override
    @Retry(name = "inventorySearch")
    public ClientResponse checkIfCarAvailable(UUID carId) {
        log.info("INVENTORY SERVICE IS DOWN!");
        throw new RuntimeException("INVENTORY SERVICE IS DOWN!");
    }
}
