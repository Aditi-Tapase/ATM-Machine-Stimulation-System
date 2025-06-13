package com.example.atm.repository;

import com.example.atm.model.Transaction;
import com.example.atm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT t FROM Transaction t WHERE t.user.cardNumber = :cardNumber")
    List<Transaction> findByUserCardNumber(@Param("cardNumber") String cardNumber);
    List<Transaction> findByUser(User user);
}

