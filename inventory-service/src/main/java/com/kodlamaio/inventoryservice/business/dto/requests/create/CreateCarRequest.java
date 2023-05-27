package com.kodlamaio.inventoryservice.business.dto.requests.create;

import com.kodlamaio.commonpackage.utils.annotations.NotFutureYear;
import com.kodlamaio.commonpackage.utils.constants.Regex;
import com.kodlamaio.inventoryservice.entities.enums.State;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {
    @NotNull
    private UUID modelId;
    @Min(value = 2000)
    @NotFutureYear
    private int modelYear;
    @NotNull
    @NotBlank
    @Pattern(regexp = Regex.Plate)
    private String plate;
    @Min(value = 1)
    private double dailyPrice;

}
