package com.example.atm.repository;

import com.example.atm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByCardNumber(String cardNumber);
}
