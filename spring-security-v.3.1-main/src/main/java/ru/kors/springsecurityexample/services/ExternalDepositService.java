package ru.kors.springsecurityexample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.kors.springsecurityexample.models.Deposit;

import java.util.Arrays;
import java.util.List;

@Service
public class ExternalDepositService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String DEPOSIT_API_URL = "http://localhost:8081/api/deposits";

    public List<Deposit> getDepositsByUserId(Long userId) {
        Deposit[] deposits = restTemplate.getForObject(DEPOSIT_API_URL + "/" + userId, Deposit[].class);
        return Arrays.asList(deposits);
    }

    public Deposit addDeposit(Deposit deposit) {
        return restTemplate.postForObject(DEPOSIT_API_URL, deposit, Deposit.class);
    }
    public Deposit getDepositById(Long depositId) {
        return restTemplate.getForObject(DEPOSIT_API_URL + "/{id}", Deposit.class, depositId);
    }

}
