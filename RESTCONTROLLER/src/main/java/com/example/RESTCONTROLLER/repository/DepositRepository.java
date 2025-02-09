package com.example.RESTCONTROLLER.repository;

import com.example.RESTCONTROLLER.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DepositRepository extends JpaRepository<Deposit, Long> {
    List<Deposit> findByUserId(Long userId);
}