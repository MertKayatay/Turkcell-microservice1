package com.kodlamaio.inventoryservice.business.rules;

import com.kodlamaio.inventoryservice.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
    private final ModelRepository repository;
    public void checkIfModelExistsById(UUID id) {
        if (!repository.existsById(id)) throw new IllegalArgumentException("Model Not Exists");//BusinessException(Messages.Model.NotExists);
    }

    public void checkIfModelExistsByName(String name) {
        if (repository.existsByNameIgnoreCase(name))
            throw new IllegalArgumentException("Model Exists");//BusinessException(Messages.Model.Exists);
    }
}
