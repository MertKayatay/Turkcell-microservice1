package com.kodlamaio.invoiceservice.business.kafka.consumers;

import com.kodlamaio.commonpackage.events.inventory.CarCreatedEvent;
import com.kodlamaio.commonpackage.events.rental.RentalCreatedEvent;
import com.kodlamaio.commonpackage.events.rental.RentalInvoiceCreatedEvent;
import com.kodlamaio.commonpackage.utils.constants.Paths;
import com.kodlamaio.commonpackage.utils.mappers.ModelMapperService;
import com.kodlamaio.invoiceservice.business.abstracts.InvoiceService;
import com.kodlamaio.invoiceservice.business.dto.requests.create.CreateInvoiceRequest;
import com.kodlamaio.invoiceservice.entities.Invoice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RentalConsumer {
    private final InvoiceService service;
    private final ModelMapperService mapper;

    @KafkaListener(
            topics = "rental-invoice-created",
            groupId = "rental-invoice-create"
    )
    public void consume(RentalInvoiceCreatedEvent event){
        var invoice=mapper.forRequest().map(event, CreateInvoiceRequest.class);
        service.add(invoice);
        log.info("rental created event consumed for invoice{}",event);
    }
}
