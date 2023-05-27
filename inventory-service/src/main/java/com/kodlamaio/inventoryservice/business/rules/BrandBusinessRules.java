package com.kodlamaio.inventoryservice.business.rules;

import com.kodlamaio.inventoryservice.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private final BrandRepository repository;
    public void checkIfBrandExistsById(UUID id) {
        if (!repository.existsById(id)) throw new IllegalArgumentException("Brand Not Exists");//BusinessException(Messages.Brand.NotExists);
    }
    public void checkIfBrandExistsByName(String name){
        if (repository.existsByNameIgnoreCase(name))
            throw new IllegalArgumentException("Brand Exists");//BusinessException(Messages.Brand.Exists);
    }
}
