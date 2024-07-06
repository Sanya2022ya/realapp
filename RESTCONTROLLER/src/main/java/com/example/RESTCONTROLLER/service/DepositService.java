package com.example.RESTCONTROLLER.service;

import com.example.RESTCONTROLLER.model.Deposit;
import com.example.RESTCONTROLLER.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepositService {

    @Autowired
    private DepositRepository depositRepository;

    public List<Deposit> getDepositsByUserId(Long userId) {
        return depositRepository.findByUserId(userId);
    }

    public Deposit addDeposit(Deposit deposit) {
        return depositRepository.save(deposit);
    }
}
