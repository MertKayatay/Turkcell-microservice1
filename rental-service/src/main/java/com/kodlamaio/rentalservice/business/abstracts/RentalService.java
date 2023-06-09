package com.kodlamaio.rentalservice.business.abstracts;

import com.kodlamaio.rentalservice.business.dto.requests.CreateRentalRequest;
import com.kodlamaio.rentalservice.business.dto.requests.UpdateRentalRequest;
import com.kodlamaio.rentalservice.business.dto.response.CreateRentalResponse;
import com.kodlamaio.rentalservice.business.dto.response.GetAllRentalsResponse;
import com.kodlamaio.rentalservice.business.dto.response.GetRentalResponse;
import com.kodlamaio.rentalservice.business.dto.response.UpdateRentalResponse;

import java.util.List;
import java.util.UUID;

public interface RentalService {
    List<GetAllRentalsResponse> getAll();
    GetRentalResponse getById(UUID id);
    CreateRentalResponse add(CreateRentalRequest request);
    UpdateRentalResponse update(UUID id, UpdateRentalRequest request);
    void delete(UUID id);
}
