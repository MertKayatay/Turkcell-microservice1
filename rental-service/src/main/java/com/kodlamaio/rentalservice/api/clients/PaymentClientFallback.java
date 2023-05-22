package com.kodlamaio.rentalservice.api.clients;

import com.kodlamaio.commonpackage.utils.dto.ClientResponse;
import com.kodlamaio.commonpackage.utils.dto.CreateRentalPaymentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@EnableScheduling
public class PaymentClientFallback implements PaymentClient{

    @Override
    public ClientResponse paymentValidation(CreateRentalPaymentRequest request) {
        log.info("PAYMENT SERVICE IS DOWN!");
        throw new RuntimeException("PAYMENT SERVICE IS DOWN!");
    }

}
