package com.example.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atm.model.AtmBalance;
import com.example.atm.repository.AtmBalanceRepository;

@Service
public class AdminService {
    @Autowired
    private AtmBalanceRepository atmBalanceRepository;

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    public boolean login(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    public String loadCash(double amount) {
        AtmBalance atm = atmBalanceRepository.findById(1).orElse(new AtmBalance(0));
        atm.setTotalCash(atm.getTotalCash() + amount);
        atmBalanceRepository.save(atm);
        return "ATM reloaded with Rs." + amount;
    }

    public double viewAtmBalance() {
        return atmBalanceRepository.findById(1).orElse(new AtmBalance(0)).getTotalCash();
    }
}