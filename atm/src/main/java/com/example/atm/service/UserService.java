package com.example.atm.service;

import com.example.atm.model.*;
import com.example.atm.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AtmBalanceRepository atmBalanceRepository;

    public String register(String cardNumber, String pin) {
        if (userRepository.findByCardNumber(cardNumber).isPresent()) {
            return "Card number already exists.";
        }
        userRepository.save(new User(cardNumber, pin, 0.0));
        return "User registered successfully.";
    }

    public String login(String cardNumber, String pin) {
        Optional<User> userOpt = userRepository.findByCardNumber(cardNumber);
        if (userOpt.isPresent() && userOpt.get().getPin().equals(pin)) {
            return "Login successful.";
        }
        return "Invalid credentials.";
    }

    public String deposit(String cardNumber, double amount) {
        Optional<User> userOpt = userRepository.findByCardNumber(cardNumber);
        if (userOpt.isEmpty()) return "User not found.";

        User user = userOpt.get();
        user.setBalance(user.getBalance() + amount);
        userRepository.save(user);

        AtmBalance atm = atmBalanceRepository.findById(1).orElse(new AtmBalance(0));
        atm.setTotalCash(atm.getTotalCash() + amount);
        atmBalanceRepository.save(atm);

        transactionRepository.save(new Transaction("DEPOSIT", amount, LocalDateTime.now(), user));

        return "Deposit successful.";
    }
    public String checkBalance(String cardNumber) {
    	Optional<User> userOpt = userRepository.findByCardNumber(cardNumber);
    	if (userOpt.isEmpty()) return "User not found.";

    	User user = userOpt.get();
    	return "Current balance: ₹" + user.getBalance();

    }


    public String withdraw(String cardNumber, double amount) {
        Optional<User> userOpt = userRepository.findByCardNumber(cardNumber);
        if (userOpt.isEmpty()) return "User not found.";

        User user = userOpt.get();
        if (user.getBalance() < amount) return "Insufficient user balance.";

        AtmBalance atm = atmBalanceRepository.findById(1).orElse(new AtmBalance(0));
        if (atm.getTotalCash() < amount) return "ATM has insufficient cash.";

        user.setBalance(user.getBalance() - amount);
        userRepository.save(user);

        atm.setTotalCash(atm.getTotalCash() - amount);
        atmBalanceRepository.save(atm);

        transactionRepository.save(new Transaction("WITHDRAW", amount, LocalDateTime.now(), user));

        return "Withdrawal successful.";
    }
    
    public List<Transaction> getTransactionHistory(String cardNumber) {
        Optional<User> userOpt = userRepository.findByCardNumber(cardNumber);
        if (userOpt.isEmpty()) {
            return List.of(); // Return empty list if user not found
        }
        return transactionRepository.findByUser(userOpt.get());
    }

}