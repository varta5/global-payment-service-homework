package com.global_payment_service_homework.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.global_payment_service_homework.backend.enums.Currency;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Currency currency;
    private float balance;

    public Long getId() {
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
