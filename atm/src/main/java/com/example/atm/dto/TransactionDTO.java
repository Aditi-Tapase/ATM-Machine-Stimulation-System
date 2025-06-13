package com.example.atm.dto;

import com.example.atm.model.Transaction;

public class TransactionDTO {
    private Long id;
    private double amount;
    private String type;
    private String timestamp;

    // Constructor
    public TransactionDTO(Transaction t) {
        this.id = t.getId();
        this.amount = t.getAmount();
        this.type = t.getType();
        this.timestamp = t.getTimestamp().toString();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	
}

