package com.example.atm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "atm_balance")
public class AtmBalance {
    @Id
    private int id = 1; // Singleton row

    @Column(name = "total_cash")
    private double totalCash;

    public AtmBalance() {}

    public AtmBalance(double totalCash) {
        this.totalCash = totalCash;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getTotalCash() { return totalCash; }
    public void setTotalCash(double totalCash) { this.totalCash = totalCash; }
}
