package com.kodlamaio.inventoryservice.business.rules;

import com.kodlamaio.commonpackage.utils.exceptions.BusinessException;
import com.kodlamaio.inventoryservice.entities.enums.State;
import com.kodlamaio.inventoryservice.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CarBusinessRules {
    private final CarRepository repository;

    public void checkIfCarExists(UUID id) {
        if (!repository.existsById(id)) {
            // TODO: BusinessException
            throw new RuntimeException("CAR_NOT_EXISTS");
        }
    }
        public void checkCarAvailability(UUID id) {
            var car = repository.findById(id).orElseThrow();
            if (!car.getState().equals(State.Available)) {
                throw new BusinessException("CAR_NOT_AVAILABLE");
            }
        }
        public void checkIfCarUnderMaintenance(UUID id){
            var car = repository.findById(id).orElseThrow();
            if (car.getState().equals(State.Maintenance)) {
                throw new BusinessException("CAR_ALREADY_UNDER_MAINTENANCE");
            }
        }
        public void checkIfCarRented(UUID id){
            var car = repository.findById(id).orElseThrow();
            if (car.getState().equals(State.Rented)) {
                throw new BusinessException("CAR_IS_CURRENTLY_RENTED_AND_CAN_NOT_BE_SERVICED_FOR_MAINTENANCE");
            }
        }

}