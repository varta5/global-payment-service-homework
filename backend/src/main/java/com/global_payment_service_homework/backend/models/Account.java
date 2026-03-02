package com.global_payment_service_homework.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

import com.global_payment_service_homework.backend.enums.Currency;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Currency currency;
    private float balance;

    public UUID getId() {
        return this.id;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public float getBalance() {
        return this.balance;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

}
