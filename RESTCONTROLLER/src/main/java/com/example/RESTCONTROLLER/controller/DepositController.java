package com.example.RESTCONTROLLER.controller;

import com.example.RESTCONTROLLER.model.Deposit;
import com.example.RESTCONTROLLER.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deposits")
public class DepositController {

    @Autowired
    private DepositService depositService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Deposit>> getDepositsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(depositService.getDepositsByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Deposit> addDeposit(@RequestBody Deposit deposit) {
        return ResponseEntity.ok(depositService.addDeposit(deposit));
    }
}