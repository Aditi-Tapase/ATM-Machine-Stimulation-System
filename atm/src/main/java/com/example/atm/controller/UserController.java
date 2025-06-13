package com.example.atm.controller;


import com.example.atm.dto.TransactionDTO;
import com.example.atm.model.Transaction;
import com.example.atm.service.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestParam String cardNumber, @RequestParam String pin) {
        return userService.register(cardNumber, pin);
    }
    @GetMapping("/balance")
    public String checkBalance(@RequestParam String cardNumber) {
        return userService.checkBalance(cardNumber);
    }


    @PostMapping("/login")
    public String login(@RequestParam String cardNumber, @RequestParam String pin) {
        return userService.login(cardNumber, pin);
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam String cardNumber, @RequestParam double amount) {
        return userService.deposit(cardNumber, amount);
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam String cardNumber, @RequestParam double amount) {
        return userService.withdraw(cardNumber, amount);
    }
    @GetMapping("/transactions")
    public ResponseEntity<List<TransactionDTO>> getTransactions(@RequestParam String cardNumber) {
        List<Transaction> transactions = userService.getTransactionHistory(cardNumber); // ✅ FIXED
        List<TransactionDTO> result = transactions.stream()
            .map(TransactionDTO::new)
            .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }


}
