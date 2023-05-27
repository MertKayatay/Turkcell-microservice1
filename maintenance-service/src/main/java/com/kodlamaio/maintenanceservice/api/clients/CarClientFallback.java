package com.kodlamaio.maintenanceservice.api.clients;

import com.kodlamaio.commonpackage.utils.dto.ClientResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@EnableScheduling
public class CarClientFallback implements CarClient {

    //@Scheduled(fixedRate = 5000)
    @Override

    public ClientResponse checkIfCarAvailable(UUID carId) {
        log.info("INVENTORY SERVICE IS DOWN!");
        throw new RuntimeException("INVENTORY SERVICE IS DOWN!");
    }

    @Override
    public ClientResponse checkIfCarAvailableForMaintenance(UUID carId) {
        log.info("INVENTORY SERVICE IS DOWN!");
        throw new RuntimeException("INVENTORY SERVICE IS DOWN!");

    }
}
