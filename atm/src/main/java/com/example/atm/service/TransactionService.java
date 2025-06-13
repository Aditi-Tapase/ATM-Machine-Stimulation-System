package com.example.atm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atm.model.Transaction;
import com.example.atm.repository.TransactionRepository;
import com.example.atm.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getTransactionsByCardNumber(String cardNumber) {
        return transactionRepository.findByUserCardNumber(cardNumber);
    }
}

