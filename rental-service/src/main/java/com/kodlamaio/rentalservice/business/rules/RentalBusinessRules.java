package com.kodlamaio.rentalservice.business.rules;

import com.kodlamaio.commonpackage.utils.dto.ClientResponse;
import com.kodlamaio.commonpackage.utils.dto.CreateRentalPaymentRequest;
import com.kodlamaio.commonpackage.utils.exceptions.BusinessException;
import com.kodlamaio.rentalservice.api.clients.CarClient;
import com.kodlamaio.rentalservice.api.clients.PaymentClient;
import com.kodlamaio.rentalservice.repository.RentalRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
@Slf4j
@Service
@AllArgsConstructor
public class RentalBusinessRules {
    private final RentalRepository repository;
    private final CarClient carClient;
    private final PaymentClient paymentClient;

    public void checkIfRentalExists(UUID id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("MODEL_NOT_EXISTS");
        }
    }
    public void ensureCarIsAvailable(UUID carId) {
        var response = carClient.checkIfCarAvailable(carId);
        if (!response.isSuccess()) {
            throw new BusinessException(response.getMessage());
        }
    }

    public void ensurePaymentValid(CreateRentalPaymentRequest request){
        var response= paymentClient.paymentValidation(request);
        if (!response.isSuccess()){
            throw new BusinessException(response.getMessage());
        }
    }

}
/*ASENKRON OLDUĞU İÇİN ÇALIŞTIRAMADIK :(((
  public void ensureCarIsAvailable(UUID carId) {
        final ClientResponse[] response = new ClientResponse[1];
        final int[] flag = {5};

        TimerTask task = new TimerTask() {
            public synchronized void  run() {

                try {
                    log.info("try worked!!");
                    response[0] =client.checkIfCarAvailable(carId);
                    flag[0] =-1;


                } catch (RuntimeException e) {
                    flag[0]--;
                    if(flag[0] ==0){
                        throw e;
                    }


                }

            }
        };
        Timer timer = new Timer("Timer");

        long delay = 3000L;





            timer.schedule(task, delay, 5);






    }

 */