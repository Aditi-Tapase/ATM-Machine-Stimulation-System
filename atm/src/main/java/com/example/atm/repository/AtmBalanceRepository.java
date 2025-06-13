package com.example.atm.repository;

import com.example.atm.model.AtmBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtmBalanceRepository extends JpaRepository<AtmBalance, Integer> {
    // You can add custom queries if needed
}

