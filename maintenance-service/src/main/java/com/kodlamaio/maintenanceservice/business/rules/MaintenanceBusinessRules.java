package com.kodlamaio.maintenanceservice.business.rules;

import com.kodlamaio.commonpackage.utils.exceptions.BusinessException;
import com.kodlamaio.maintenanceservice.api.clients.CarClient;
import com.kodlamaio.maintenanceservice.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {
    private final CarClient client;
    private final MaintenanceRepository repository;
    public void checkIfMaintenanceExists(UUID id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("MAINTENANCE_NOT_EXISTS");
        }
    }
    public void checkIfCarAvailabeForMaintenance(UUID carId) {
        var response = client.checkIfCarAvailableForMaintenance(carId);
        if (!response.isSuccess()) {
            throw new BusinessException(response.getMessage());
        }
    }
    public void checkIfMaintenanceIsCompleted(UUID carId) {
        var maintenance = repository.findByCarIdAndIsCompletedIsFalse(carId);
        if (maintenance.isCompleted()) {
            throw new BusinessException("MAINTENANCE_IS_COMPLETED");
        }
    }



}
